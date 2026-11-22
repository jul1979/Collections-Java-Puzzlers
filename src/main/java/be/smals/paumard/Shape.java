package be.smals.paumard;

public sealed interface Shape permits Circle, Square {
    double surface();
}
