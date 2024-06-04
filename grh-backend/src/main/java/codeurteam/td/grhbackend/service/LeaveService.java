package codeurteam.td.grhbackend.service;

import codeurteam.td.grhbackend.model.Leave;
import codeurteam.td.grhbackend.model.LeaveStatus;
import codeurteam.td.grhbackend.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave createLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(Long id, Leave leaveDetails) {
        Leave leave = leaveRepository.findById(id).orElse(null);
        if (leave != null) {
            leave.setStartDate(leaveDetails.getStartDate());
            leave.setEndDate(leaveDetails.getEndDate());
            leave.setReason(leaveDetails.getReason());
            leave.setStatus(leaveDetails.getStatus());
            leave.setEmployee(leaveDetails.getEmployee());
            return leaveRepository.save(leave);
        }
        return null;
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    public Leave approveLeave(Long id) {
        Leave leave = leaveRepository.findById(id).orElse(null);
        if (leave != null) {
            leave.setStatus(LeaveStatus.APPROVED);
            return leaveRepository.save(leave);
        }
        return null;
    }

    public Leave rejectLeave(Long id) {
        Leave leave = leaveRepository.findById(id).orElse(null);
        if (leave != null) {
            leave.setStatus(LeaveStatus.REJECTED);
            return leaveRepository.save(leave);
        }
        return null;
    }
}
