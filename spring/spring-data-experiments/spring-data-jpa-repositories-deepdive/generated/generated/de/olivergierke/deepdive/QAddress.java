package de.olivergierke.deepdive;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;
import org.farrukh.examples.spring.data.jpa.Address;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = -219496217L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAddress address = new QAddress("address");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath city = createString("city");

    public final QAddress copy;

    public final StringPath country = createString("country");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath street = createString("street");

    public QAddress(String variable) {
        this(Address.class, forVariable(variable), INITS);
    }

    public QAddress(Path<? extends Address> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAddress(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAddress(PathMetadata<?> metadata, PathInits inits) {
        this(Address.class, metadata, inits);
    }

    public QAddress(Class<? extends Address> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.copy = inits.isInitialized("copy") ? new QAddress(forProperty("copy"), inits.get("copy")) : null;
    }

}

