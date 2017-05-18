package testing.mvp.common;

import java.util.concurrent.Executor;

/**
 * Created by eretamero on 17/05/2017.
 */

public abstract class BaseUseCase {

    protected Executor executor;

    public BaseUseCase(Executor executor) {
        this.executor = executor;
    }
}
