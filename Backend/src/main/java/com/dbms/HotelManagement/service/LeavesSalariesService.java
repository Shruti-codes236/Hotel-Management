package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.LeavesSalaries;
import com.dbms.HotelManagement.repository.LeavesSalariesRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LeavesSalariesService {
    private final LeavesSalariesRepository leavesSalariesRepository;

    public LeavesSalariesService(LeavesSalariesRepository leavesSalariesRepository) {
        this.leavesSalariesRepository = leavesSalariesRepository;
    }

    public int addLeavesSalaries(UUID empID, int salary, int month, int year, int leavesAllowed, int leavesTaken){
        return leavesSalariesRepository.addLeavesSalaries(empID, salary, month, year, leavesAllowed, leavesTaken);
    }

    public int addLeave(UUID empID, int leavesTaken){
        return leavesSalariesRepository.addLeave(empID, leavesTaken+1);
    }

    public LeavesSalaries getLeavesSalaries(UUID empID, int month, int year){
        return leavesSalariesRepository.getLeavesSalaries(empID, month, year);
    }

    public int paySalary(UUID empID, int month, int year, int salary,int leavesAllowed){
        int i = leavesSalariesRepository.paySalary(empID, month, year, salary);
        if(month == 12){
            month = 1;
            year = year+1;
        }
        else{
            month += 1;
        }
        return leavesSalariesRepository.addLeavesSalaries(empID, -1, month, year, leavesAllowed, 0);

//        return leavesSalariesRepository.changeMonth(empID, month, year);
    }
}
