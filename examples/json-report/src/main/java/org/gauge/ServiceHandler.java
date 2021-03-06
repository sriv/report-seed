package org.gauge;

import com.thoughtworks.gauge.Messages;
import com.thoughtworks.gauge.ReporterGrpc;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;


class ServiceHandler extends ReporterGrpc.ReporterImplBase {

    private Server server;

    @Override
    public void notifyExecutionStarting(Messages.ExecutionStartingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifySpecExecutionStarting(Messages.SpecExecutionStartingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifyScenarioExecutionStarting(Messages.ScenarioExecutionStartingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifyStepExecutionStarting(Messages.StepExecutionStartingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifyStepExecutionEnding(Messages.StepExecutionEndingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifyScenarioExecutionEnding(Messages.ScenarioExecutionEndingRequest
                                                      request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifySpecExecutionEnding(Messages.SpecExecutionEndingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifyExecutionEnding(Messages.ExecutionEndingRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void notifySuiteResult(Messages.SuiteExecutionResult request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            JsonBuilder builder = new JsonBuilder();
            String file = builder.buildFrom(request.getSuiteResult());
            System.out.println("Successfully generated json-report to => " + file);
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(e);
        }
    }

    @Override
    public void kill(Messages.KillProcessRequest request, StreamObserver<Messages.Empty> responseObserver) {
        try {
            responseObserver.onNext(Messages.Empty.newBuilder().build());
            responseObserver.onCompleted();
            server.shutdownNow();
        } catch (Throwable e) {
            System.out.println(String.format("Failed to process %s.\nReason: %s", Messages.Message.MessageType.KillProcessRequest, e.toString()));
            responseObserver.onError(e);
        }
    }

    void addServer(Server server) {
        this.server = server;
    }
}
