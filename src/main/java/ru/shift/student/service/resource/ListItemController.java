package ru.shift.student.service.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.shift.student.service.resource.facade.ListItemFacade;

import java.util.List;

@RestController
@RequestMapping("api/list-items")
@RequiredArgsConstructor
public class ListItemController {

    private final ListItemFacade facade;

    @GetMapping
    public List<Object> getListItems(@RequestParam Integer page, @RequestParam Integer size) {
        return facade.get(page, size);
    }
}
