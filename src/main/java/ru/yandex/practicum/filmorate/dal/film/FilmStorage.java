package ru.yandex.practicum.filmorate.dal.film;

import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmStorage {

    Collection<Film> getAll();

    Optional<Film> get(Long id);

    Film create(Film film);

    Film update(Film film);

    void delete(Long id);

    Collection<Film> getAllFilmsByDirectorId(Long directorId);
}