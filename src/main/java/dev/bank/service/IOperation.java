package dev.bank.service;

import dev.bank.common.marker.IRequest;
import dev.bank.common.marker.IResponse;
import java.io.Serializable;

public interface IOperation<T extends IRequest, R extends IResponse> extends Serializable {
	R with(T data);
}
