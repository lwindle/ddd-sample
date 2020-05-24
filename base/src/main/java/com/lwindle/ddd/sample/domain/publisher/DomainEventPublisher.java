package com.lwindle.ddd.sample.domain.publisher;

public interface DomainEventPublisher<T> {
    public void publish(T event);

}