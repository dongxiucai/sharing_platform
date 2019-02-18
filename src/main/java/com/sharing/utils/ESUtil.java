package com.sharing.utils;

import com.alibaba.fastjson.JSONObject;
import javassist.expr.NewArray;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.*;

public class ESUtil {

    /**
     * 创建连接对象
     */
    static PreBuiltTransportClient client = null;
    static {
        // es集群名字
        Settings settings = Settings.builder().put("cluster.name", "my-es").build();
        // 创建client
        client = new PreBuiltTransportClient(settings);
        // 连接集群
        try {
            client.addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName("mini103"),9300)
            );
        }catch (Exception e){e.printStackTrace();}
    }

    /**
     * 创建索引
     * @param fileid
     * @param fileName
     * @param summary
     * @return
     */
    static public Boolean createIndex(int fileid, String fileName, String summary){
        try {
            Map<String,String> map = new HashMap<String, String>();
            map.put("fileid",String.valueOf(fileid));
            map.put("filename",fileName);
            map.put("summary",summary);

            // 创建
            client.prepareIndex("sharing","file",String.valueOf(fileid)).setSource(map).execute().actionGet();
            // 关闭连接
            client.close();

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 全文检索符合条件的fileid
     * @param search
     * @return
     */
    static public List<Integer> queryIndex(String search){
        // 文件id集合
        List<Integer> fileidList = new ArrayList<Integer>();
        // 1 条件查询
        SearchResponse searchResponse = client.prepareSearch("sharing").setTypes("file")
                .setQuery(QueryBuilders.queryStringQuery(search)).get();

        // 2 打印查询结果
        SearchHits hits = searchResponse.getHits(); // 获取命中次数，查询结果有多少对象
        System.out.println("查询结果有：" + hits.getTotalHits() + "条");

        Iterator<SearchHit> iterator = hits.iterator();

        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next(); // 每个查询对象
            System.out.println(searchHit.getSourceAsString()); // 获取字符串格式打印
            JSONObject jsonObject = JSONObject.parseObject(searchHit.getSourceAsString());
            // 获取fileid
            Integer fileid = jsonObject.getInteger("fileid");
            // 添加到集合中
            fileidList.add(fileid);
        }

        // 返回结果
        return fileidList;

    }
}
