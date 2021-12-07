package dev.bank.dto;

import dev.bank.common.marker.IDto;
import dev.bank.common.marker.IResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ResponseDisplayMovements implements Serializable, IDto, IResponse {

    private static final long serialVersionUID = 1087343275955229205L;

    private List<DisplayMovementDto> displayMovementDtoList = new ArrayList<>();

    public List<DisplayMovementDto> getDisplayMovementDtoList() {
        return Collections.unmodifiableList(displayMovementDtoList);
    }

    public void addDisplayMovement(DisplayMovementDto displayMovementDto){
        if(Objects.nonNull(displayMovementDto)){
            displayMovementDtoList.add(displayMovementDto);
        }
    }

    public void addAll(List<DisplayMovementDto> displayMovementDtoList) {
        if(Objects.nonNull(displayMovementDtoList)) {
            this.displayMovementDtoList.addAll(displayMovementDtoList);
        }
    }
}
