package com.xworkz.bakery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="baked_goods_info")
public class BakedGoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private int goodsID;

    @Column(name = "goods_name")
    private String name;

    @Column(name = "goods_type")
    private String type;

    @Column(name = "made_of")
    private String madeOf;

    @Column(name = "packaged_date")
    private Date packagedDate;

    @Column(name = "use_before_date")
    private Date useBeforeDate;
}
