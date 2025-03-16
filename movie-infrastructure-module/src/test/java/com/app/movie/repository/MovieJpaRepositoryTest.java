package com.app.movie.repository;

import com.app.movie.TestConfig;
import com.app.movie.entity.GenreEntity;
import com.app.movie.entity.MovieEntity;
import com.app.movie.model.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.SortedMap;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
class MovieJpaRepositoryTest {

    @Autowired
    MovieJpaRepository movieJpaRepository;

    @Autowired
    GenreJpaRepository genreJpaRepository;

    @Test
    public void save() {

    }


  
}