package com.charmd.hediz.dao;

import com.charmd.hediz.dto.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Repository
public class HairshopDAO {
    @Autowired
    SqlSessionTemplate session;

    public HairshopDTO findHairshop(int shop_seq) {
        return session.selectOne("com.config.HairshopMapper.findHairshop", shop_seq);
    }

    public List<HairstyleDTO> findHairstyle(int shop_seq) {
        return session.selectList("com.config.HairshopMapper.findHairstyle", shop_seq);
    }

    public HairstyleDTO findHairstyleInfor(HashMap<String, Integer> shopAndStyleMap) {
        return session.selectOne("com.config.HairshopMapper.findHairstyleInfor", shopAndStyleMap);
    }

    public List<StaffDTO> findAllStaff(int shop_seq) {
        return session.selectList("com.config.HairshopMapper.findAllStaff", shop_seq);
    }

    public StaffDTO findStaff(HashMap<String, Integer> shopSeqAndStaffSeqMap) {
        return session.selectOne("com.config.HairshopMapper.findStaff", shopSeqAndStaffSeqMap);
    }

    public List<ReviewDTO> findReview(int shop_seq) {
        return session.selectList("com.config.HairshopMapper.findReview", shop_seq);
    }

    public int isShopTempday(HashMap<String, Object> reservationFilterMap) {
        return session.selectOne("com.config.HairshopMapper.isShopTempday", reservationFilterMap);
    }

    public int isStaffTempday(HashMap<String, Object> staffSeqAndDayMap) {
        return session.selectOne("com.config.HairshopMapper.isStaffTempday", staffSeqAndDayMap);
    }

    public List<ReservationDTO> reservationFilter(HashMap<String, Object> reservationFilterMap) {
        return session.selectList("com.config.HairshopMapper.reservationFilter", reservationFilterMap);
    }

    public int duplicateCheck(PayinfoDTO payinfoDto) {
        return session.selectOne("com.config.HairshopMapper.duplicateCheck", payinfoDto);
    }

    public int reservation(PayinfoDTO payinfoDto) {
        return session.insert("com.config.HairshopMapper.reservation", payinfoDto);
    }

    public int findReservSeq(PayinfoDTO payinfoDto) {
        return session.selectOne("com.config.HairshopMapper.findReservSeq", payinfoDto);
    }

    public PayinfoDTO getPayinfo(PayinfoDTO payinfoDto) {
        return session.selectOne("com.config.HairshopMapper.getPayinfo", payinfoDto);
    }

    public int payment(PayinfoDTO payinfoDto) {
        return session.insert("com.config.HairshopMapper.payment", payinfoDto);
    }

    public void levelUpdate(int cust_seq){
        session.update("com.config.HairshopMapper.levelUpdate", cust_seq);
    }

    public int isDuplicated(PayinfoDTO payinfoDto){
        return session.selectOne("com.config.HairshopMapper.isDuplicated", payinfoDto);
    }

    public int insertCToken(PayinfoDTO payinfoDto) {
        return session.insert("com.config.HairshopMapper.insertCToken", payinfoDto);
    }
}
