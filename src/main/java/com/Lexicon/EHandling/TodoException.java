package com.Lexicon.EHandling;

public class TodoException extends RuntimeException {
    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TodoException(String message) {
        super(message);
    }


    public static class CreateException extends TodoException {
        public CreateException(String message, Throwable cause) {
            super(message, cause);
        }

        public CreateException(String message) {
            super(message);
        }
    }

    public static class FindAllException extends TodoException {
        public FindAllException(String message, Throwable cause) {
            super(message, cause);
        }

        public FindAllException(String message) {
            super(message);
        }
    }

    public static class FindByIdException extends TodoException {
        public FindByIdException(String message, Throwable cause) {
            super(message, cause);
        }

        public FindByIdException(String message) {
            super(message);
        }
    }

    public static class FindByDoneStatusException extends TodoException {
        public FindByDoneStatusException(String message, Throwable cause) {
            super(message, cause);
        }

        public FindByDoneStatusException(String message) {
            super(message);
        }
    }

    public static class FindByAssigneeException extends TodoException {
        public FindByAssigneeException(String message, Throwable cause) {
            super(message, cause);
        }

        public FindByAssigneeException(String message) {
            super(message);
        }
    }

    public static class FindByUnassignedTodosException extends TodoException {
        public FindByUnassignedTodosException(String message, Throwable cause) {
            super(message, cause);
        }

        public FindByUnassignedTodosException(String message) {
            super(message);
        }
    }

    public static class UpdateException extends TodoException {
        public UpdateException(String message, Throwable cause) {
            super(message, cause);
        }

        public UpdateException(String message) {
            super(message);
        }
    }

    public static class DeleteByIdException extends TodoException {
        public DeleteByIdException(String message, Throwable cause) {
            super(message, cause);
        }

        public DeleteByIdException(String message) {
            super(message);
        }
    }


}
