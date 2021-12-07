package dev.bank.parser;

import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IEntity;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public interface IParser<E extends IEntity, D extends IDto> extends Serializable {

    default List<E> toEntityList(List<D> dtoList){

        return dtoList.stream()
                .map(this::parse)
                .collect(Collectors.toList());

    }

    default List<D> toDtoList(List<E> entityList){
        return entityList.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    E parse(D dto);
    D parse(E entity);


}
