package com.ssafit.model.service;

import java.util.List;
import com.ssafit.model.dto.Video;

public interface VideoService {
    // 영상 상세 보기
    public abstract Video getVideo(int videoId);

    // 영상 등록
    public abstract void videoAdd(Video video);

    // 영상 전체 목록
    public abstract List<Video> getVideoList();

    // 영상 수정
    public abstract void videoUpdate(Video video);

    // 영상 삭제
    public abstract void videoDelete(int videoId);
}
