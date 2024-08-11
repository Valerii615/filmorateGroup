package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.storage.film.MpaStorage;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class MpaService {

    MpaStorage mpaStorage;

    @Autowired
    public MpaService(MpaStorage mpaStorage) {
        this.mpaStorage = mpaStorage;
    }

    public Mpa get(int id) {
        return mpaStorage.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Жанр с id=%d не найден", id)));
    }

    public Collection<Integer> getAllMpasId() {
        return mpaStorage.getAll().stream().map(Mpa::getId).collect(Collectors.toList());
    }
}
