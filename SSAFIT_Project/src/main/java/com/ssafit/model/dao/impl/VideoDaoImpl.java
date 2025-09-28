package com.ssafit.model.dao.impl;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;

public class VideoDaoImpl implements VideoDao {
    private static VideoDao dao = new VideoDaoImpl();
    private Map<Integer, Video> map = new HashMap<>();
    private AtomicInteger count = new AtomicInteger(8); // 초기 데이터 id 끝 번호

    private VideoDaoImpl() {
        getInit();
    }

    public static VideoDao getInstance() {
        return dao;
    }

    // 초기 데이터 셋업
    private void getInit() {
        map.put(1, new Video(1, "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", 
            "https://www.youtube.com/embed/gMaB-fG4u4g", "전신", "ThankyouBUBU"));
        map.put(2, new Video(2, "하루 15분! 전신 칼로리 불태우는 다이어트 운동", 
            "https://www.youtube.com/embed/swRNeYw1JkY", "전신", "ThankyouBUBU"));
        map.put(3, new Video(3, "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", 
            "https://www.youtube.com/embed/54tTYO-vU2E", "상체", "ThankyouBUBU"));
        map.put(4, new Video(4, "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", 
            "https://www.youtube.com/embed/QqqZH3j_vH0", "상체", "ThankyouBUBU"));
        map.put(5, new Video(5, "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", 
            "https://www.youtube.com/embed/tzN6ypk6Sps", "하체", "김강민"));
        map.put(6, new Video(6, "저는 하체 식주의자 입니다", 
            "https://www.youtube.com/embed/u5OgcZdNbMo", "하체", "GYM종국"));
        map.put(7, new Video(7, "11자복근 복부 최고의 운동 [복근 핵매운맛]", 
            "https://www.youtube.com/embed/PjGcOP-TQPE", "복부", "ThankyouBUBU"));
        map.put(8, new Video(8, "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", 
            "https://www.youtube.com/embed/7TLk7pscICk", "복부", "SomiFit"));
    }

    private int updateCount() {
        return count.incrementAndGet();
    }

    @Override
    public Video getVideo(int videoId) {
        return map.get(videoId);
    }

    @Override
    public void videoAdd(Video video) {
        video.setId(updateCount());
        map.put(video.getId(), video);
    }

    @Override
    public List<Video> getVideoList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void videoUpdate(Video video) {
        map.put(video.getId(), video);
    }

    @Override
    public void videoDelete(int videoId) {
        map.remove(videoId);
    }
}
