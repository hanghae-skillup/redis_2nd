package project.redis.seat.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeatEntity is a Querydsl query type for SeatEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeatEntity extends EntityPathBase<SeatEntity> {

    private static final long serialVersionUID = -394982862L;

    public static final QSeatEntity seatEntity = new QSeatEntity("seatEntity");

    public final project.redis.common.entity.QBaseEntity _super = new project.redis.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final NumberPath<Integer> seatColumn = createNumber("seatColumn", Integer.class);

    public final NumberPath<Long> seatId = createNumber("seatId", Long.class);

    public final StringPath seatRow = createString("seatRow");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public QSeatEntity(String variable) {
        super(SeatEntity.class, forVariable(variable));
    }

    public QSeatEntity(Path<? extends SeatEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeatEntity(PathMetadata metadata) {
        super(SeatEntity.class, metadata);
    }

}

