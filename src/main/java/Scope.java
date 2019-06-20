/**
 * Represents the scope of permissions for a variable
 */
public enum Scope {
    /**
     * Local scope.
     *
     * Able to read and write to own data.
     * Cannot access another bots version.
     *
     */
    Local,

    /**
     * Read only.
     *
     * Only the owner of the data may write to it.  Other bots may only read.
     */
    AllRead,

    /**
     * Read and Write.
     *
     * All bots may read and write to another bots data.
     */
    AllWrite,

    /**
     * Actuator.
     *
     * Assign to it to send data.  Examples include a motor.
     */
    Actuator,

    /**
     * Sensor.
     *
     * Read to get value.
     */
    Sensor,
}
