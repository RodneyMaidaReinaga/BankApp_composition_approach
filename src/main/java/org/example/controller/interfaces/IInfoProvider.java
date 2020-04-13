package org.example.controller.interfaces;

public interface IInfoProvider<TInfo, TId> {
    TInfo get(TId id);
}
