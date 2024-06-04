package codeurteam.td.grhbackend.controller;

import codeurteam.td.grhbackend.model.Leave;
import codeurteam.td.grhbackend.model.LeaveStatus;
import codeurteam.td.grhbackend.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable Long id) {
        Leave leave = leaveService.getLeaveById(id);
        return ResponseEntity.ok(leave);
    }

    @PostMapping
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        Leave newLeave = leaveService.createLeave(leave);
        return ResponseEntity.ok(newLeave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leave> updateLeave(@PathVariable Long id, @RequestBody Leave leaveDetails) {
        Leave updatedLeave = leaveService.updateLeave(id, leaveDetails);
        return ResponseEntity.ok(updatedLeave);
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Leave> approveLeave(@PathVariable Long id) {
        Leave leave = leaveService.getLeaveById(id);
        if (leave == null) {
            return ResponseEntity.notFound().build();
        }
        leave.setStatus(LeaveStatus.APPROVED);
        Leave updatedLeave = leaveService.updateLeave(id, leave);
        return ResponseEntity.ok(updatedLeave);
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Leave> rejectLeave(@PathVariable Long id) {
        Leave leave = leaveService.getLeaveById(id);
        if (leave == null) {
            return ResponseEntity.notFound().build();
        }
        leave.setStatus(LeaveStatus.REJECTED);
        Leave updatedLeave = leaveService.updateLeave(id, leave);
        return ResponseEntity.ok(updatedLeave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }
}
