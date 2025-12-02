package org.example.springsoap.dto;

import java.util.List;

public class PositionsResponse {

    private List<PositionRaw> positions;

    public List<PositionRaw> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionRaw> positions) {
        this.positions = positions;
    }
}
