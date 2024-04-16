package me.axolotl.api.interfaces;

/**
 * The Cancellable interface represents an entity that can be canceled.
 *
 * @since 2024-02-08
 */
public interface Cancellable {

    /**
     * Sets the cancellation status of the entity.
     *
     * @param canceled true if the entity should be canceled, false otherwise.
     */
    void setCancel(boolean canceled);

    /**
     * Checks if the entity is canceled.
     *
     * @return true if the entity is canceled, false otherwise.
     */
    boolean isCanceled();

}
