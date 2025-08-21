package ru.shift.student.service.resource.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.shift.student.service.core.service.StudentService;
import ru.shift.student.service.resource.dto.BannerItemDto;
import ru.shift.student.service.resource.dto.StudentDto;
import ru.shift.student.service.resource.mapper.StudentMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ListItemFacade {

   private static final List<BannerItemDto> BANNERS = List.of(
            new BannerItemDto("Новая заявка", "Здравствуйте, меня зовут Глеб. Подскажите, ещё можно подать заявку на курс?"),
            new BannerItemDto("Новая заявка", "Добрый день, меня зовут Анна. Скажите, не поздно ли присоединиться к обучению?"),
            new BannerItemDto("Новая заявка", "Приветствую, меня зовут Максим. Успею ли я подать документы до конца недели?"),
            new BannerItemDto("Новая заявка", "Здравствуйте, меня зовут Ольга. Можно ли ещё успеть подать заявку на этот поток?"),
            new BannerItemDto("Новая заявка", "Добрый вечер, меня зовут Артём. Принимаете ли вы заявки на следующий месяц?"),
            new BannerItemDto("Новая заявка", "Привет, меня зовут Карина. Подскажите, есть ли свободные места в группе?"),
            new BannerItemDto("Новая заявка", "Добрый день, меня зовут Дмитрий. Интересуюсь, продлён ли набор на курс?"),
            new BannerItemDto("Новая заявка", "Здравствуйте, меня зовут Виктория. Уточните, можно ли подать заявку сегодня?"),
            new BannerItemDto("Новая заявка", "Приветствую, меня зовут Сергей. Есть ли возможность записаться после дедлайна?"),
            new BannerItemDto("Новая заявка", "Добрый вечер, меня зовут Елена. Скажите, принимаются ли ещё заявки?")
    );

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public List<Object> get(int page, int size) {
        List<StudentDto> studentDtos = studentMapper.toStudentDtoList(
                studentService.get(PageRequest.of(page, size - 1))
        );
        List<Object> listItems = new ArrayList<>();
        listItems.addAll(studentDtos);
        listItems.add(BANNERS.get(ThreadLocalRandom.current().nextInt(BANNERS.size())));
        return listItems;
    }
}
