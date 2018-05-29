package com.evelyn.jdk8.stream;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 功能说明：ParallelStream的线程安全问题测试
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月29日上午10:53]
 */
public class ParallelStreamTest {
    private static final int COUNT = 1000;
    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {

            long start = System.currentTimeMillis();
            // parallelStream的foreach在进行ArrayList的add时会发生并行安全问题
            testForEach();
            System.out.println("conusing : " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            // parallelStream的map，collect去返回实体，没有并行安全问题
            testMap();
            System.out.println("m conusing : " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();

            // stream的foreach在进行ArrayList的add时不会发生并行安全问题
            testForEachStream();
            System.out.println("str conusing : " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            // stream在进行map，collect去返回实体，没有并行安全问题
            teststream();
            System.out.println("s conusing : " + (System.currentTimeMillis() - start));
        }
    }

    private static void testForEach() {
        List<RiderDto> orilist=new ArrayList<RiderDto>();
        for(int i=0;i<COUNT;i++){
            orilist.add(init());
        }
        final List<RiderDto> copeList=new ArrayList<RiderDto>();
        orilist.parallelStream().forEach(rider -> {
            RiderDto t = new RiderDto();
            t.setId(rider.getId());
            t.setCityId(rider.getCityId());
            copeList.add(t);
        });
        System.out.println("orilist size:"+orilist.size());
        System.out.println("copeList size:"+copeList.size());
        System.out.println("compare copeList and list,result:"+(copeList.size()==orilist.size()));
    }

    private static void testForEachStream() {
        List<RiderDto> orilist=new ArrayList<RiderDto>();
        for(int i=0;i<COUNT;i++){
            orilist.add(init());
        }
        final List<RiderDto> copeList=new ArrayList<RiderDto>();
        orilist.stream().forEach(rider -> {
            RiderDto t = new RiderDto();
            t.setId(rider.getId());
            t.setCityId(rider.getCityId());
            copeList.add(t);
        });
        System.out.println("str: orilist size:"+orilist.size());
        System.out.println("str: copeList size:"+copeList.size());
        System.out.println("str: compare copeList and list,result:"+(copeList.size()==orilist.size()));
    }

    private static void testMap() {
        List<RiderDto> orilist=new ArrayList<RiderDto>();
        for(int i=0;i<COUNT;i++){
            orilist.add(init());
        }

        final List<RiderDto> copeList = orilist.parallelStream().map(rider -> {
            RiderDto t = new RiderDto();
            t.setId(rider.getId());
            t.setCityId(rider.getCityId());
            return t;
        }).collect(Collectors.toList());
        System.out.println("m： orilist size:"+orilist.size());
        System.out.println("m:  copeList size:"+copeList.size());
        System.out.println("M:  compare copeList and list,result:"+(copeList.size()==orilist.size()));
    }

    private static void teststream() {
        List<RiderDto> orilist=new ArrayList<RiderDto>();
        for(int i=0;i<COUNT;i++){
            orilist.add(init());
        }

        final List<RiderDto> copeList = orilist.stream().map(rider -> {
            RiderDto t = new RiderDto();
            t.setId(rider.getId());
            t.setCityId(rider.getCityId());
            return t;
        }).collect(Collectors.toList());
        System.out.println("s： orilist size:"+orilist.size());
        System.out.println("s:  copeList size:"+copeList.size());
        System.out.println("s:  compare copeList and list,result:"+(copeList.size()==orilist.size()));
    }

    private static RiderDto init() {
        RiderDto t = new RiderDto();
        Random random = new Random();
        t.setId(random.nextInt(2 ^ 20));
        t.setCityId(random.nextInt(1000));
        return t;
    }


    @Data
    static class RiderDto implements Serializable{
        private static final long serialVersionUID = 1;
        //城市Id
        private Integer cityId;
        //骑手Id
        private Integer id;
/*
        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }*/
    }
}