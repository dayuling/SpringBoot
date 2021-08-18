package com.example.demo;

import com.example.demo.entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.logging.Logger;

@Slf4j
public class Main {

    public static void main(String[] args) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();

        Member buildMember = new Member("myID", "myname", "koscom");
                // Member.builder().id("myid").name("myname").org("koscom").build();

        //직렬화
        String json = mapper.writeValueAsString(buildMember);
        byte[] byteStream = json.getBytes(); //네트워크 전송용
        System.out.println(json);

        log.debug("Debugging message");

        //역직렬화
        String inputString = new String(byteStream);
        Map readObject = mapper.readValue(json, Map.class);
        System.out.println(readObject);

    }
}
