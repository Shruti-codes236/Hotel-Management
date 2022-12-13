package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Member;
import com.dbms.HotelManagement.repository.BookingRepository;
import com.dbms.HotelManagement.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int addMember(UUID bookingID,int countMember, List<Member> members){
        try{
            for(int i=0;i<countMember;i++){
                memberRepository.registerMember(bookingID, members.get(i).getAadharNo(), members.get(i).getAge(), members.get(i).getFname(), members.get(i).getLname());
            }
            return 1;
        }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}