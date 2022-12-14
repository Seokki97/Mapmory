package com.example.mapmory.marker.domain;
import com.example.mapmory.diary.domain.Diary;
import com.example.mapmory.member.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "marker_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "marker", cascade = CascadeType.REMOVE)
    private List<Diary> articles = new ArrayList<>();
    private Double longtitude;

    private Double latitude;


    @Builder//생성자에 @builder 붙이면 빌더 패턴 사용 가능함 선택적인 인자만 사용하여 인스턴스 생성
    public Marker(Member member, Double longtitude, Double latitude) {
        this.member = member;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }


}