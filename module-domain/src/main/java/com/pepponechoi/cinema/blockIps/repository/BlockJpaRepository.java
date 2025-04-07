package com.pepponechoi.cinema.blockIps.repository;

import com.pepponechoi.cinema.blockIps.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockJpaRepository extends JpaRepository<Block, Long>, BlockRepository {

}
