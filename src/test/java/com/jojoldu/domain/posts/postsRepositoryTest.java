package com.jojoldu.domain.posts;

import com.jojoldu.domain.posts.posts;
import com.jojoldu.domain.posts.postsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class postsRepositoryTest {

    @Autowired
    postsRepository PostsRepository;

    @After
    public void cleanup() {
        PostsRepository.deleteAll();

    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        PostsRepository.save(posts.builder()
                .title(title)
                .content(content)
                .author("jojo@gmail.com")
                .build());

        //when
        List<posts> postsList = PostsRepository.findAll();

        //then
        posts Posts = postsList.get(0);
        assertThat(Posts.getTitle()).isEqualTo(title);
        assertThat(Posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2022,2,10,0,0,0);
        PostsRepository.save(posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        //when
        List<posts> postsList = PostsRepository.findAll();

        //then
        posts Posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+Posts.getCreatedDate()+", modifiedDate="+Posts.getModifiedDate());

        assertThat(Posts.getCreatedDate()).isAfter(now);
        assertThat(Posts.getModifiedDate()).isAfter(now);

    }

}
