package org.xpectranet.x0agent.ritual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ritual")
public class RitualController {

    private final RitualService ritualService;

    @Autowired
    public RitualController(RitualService ritualService) {
        this.ritualService = ritualService;
    }

    @PostMapping("/mint")
    public String mint(@RequestParam String content) {
        return ritualService.mint(content);
    }

    @PostMapping("/remix")
    public String remix(@RequestParam String sourceId) {
        return ritualService.remix(sourceId);
    }

    @PostMapping("/validate")
    public String validate(@RequestParam String insightId) {
        return ritualService.validate(insightId);
    }
}