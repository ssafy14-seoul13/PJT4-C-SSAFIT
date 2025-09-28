package com.ssafit.model.dao;

import java.util.List;
import com.ssafit.model.dto.Video;

public interface VideoDao {
    // 영상 상세 보기
    Video getVideo(int videoId);

    // 영상 등록
    void videoAdd(Video video);

    // 영상 전체 목록
    List<Video> getVideoList();

    // 영상 수정
    void videoUpdate(Video video);

    // 영상 삭제
    void videoDelete(int videoId);
}
