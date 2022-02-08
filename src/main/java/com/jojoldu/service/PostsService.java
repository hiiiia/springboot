package com.jojoldu.service;

import com.jojoldu.dto.PostsResponseDto;
import com.jojoldu.dto.PostsSaveRequestDto;
import com.jojoldu.dto.PostsUpdateRequestDto;
import com.jojoldu.domain.posts.posts;
import com.jojoldu.domain.posts.postsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

        private final postsRepository PostsRepository;

        @Transactional
        public Long save(PostsSaveRequestDto requestDto) {
            return PostsRepository.save(requestDto.toEntity()).getId();
        }
        @Transactional
        public Long update(Long id, PostsUpdateRequestDto requestDto) {
            posts Posts = PostsRepository.findById(id)
                    .orElseThrow(()->new IllegalArgumentException("해당 게시글 없음. id="+id));

            Posts.update(requestDto.getTitle(),requestDto.getContent());

            return id;
        }

        public PostsResponseDto findById (Long id){
            posts entity = PostsRepository.findById(id)
                    .orElseThrow(()->new IllegalArgumentException("해당 게시글 없음. id=" + id));
            return new PostsResponseDto(entity);
        }
}
