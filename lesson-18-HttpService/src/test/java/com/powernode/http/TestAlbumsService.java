package com.powernode.http;

import com.powernode.http.model.Albums;
import com.powernode.http.record.AlbumsRecord;
import com.powernode.http.service.AlbumsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAlbumsService {

    @Autowired
    private AlbumsService albumsService;

    @Test
    void testQuery() {
        Albums albums = albumsService.getById(5);
        System.out.println(albums);
    }

    @Test
    void testRecord() {
        AlbumsRecord byIdReturnRecord = albumsService.getByIdReturnRecord(21);
        System.out.println(byIdReturnRecord);
    }


}
