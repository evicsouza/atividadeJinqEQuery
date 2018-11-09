package br.edu.ifpe.jpa.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClient is a Querydsl query type for Client
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClient extends EntityPathBase<Client> {

    private static final long serialVersionUID = -509693281L;

    public static final QClient client = new QClient("client");

    public final CollectionPath<Account, QAccount> accounts = this.<Account, QAccount>createCollection("accounts", Account.class, QAccount.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> identifier = createNumber("identifier", Integer.class);

    public final StringPath name = createString("name");

    public QClient(String variable) {
        super(Client.class, forVariable(variable));
    }

    public QClient(Path<? extends Client> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClient(PathMetadata metadata) {
        super(Client.class, metadata);
    }

}

