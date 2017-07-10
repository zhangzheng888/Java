/*
 * MountainFactory
 *
 *   This class provides a uniform way to obtain "mountains", which
 *   are really just trees (and the one function below returns the
 *   root of the tree).
 */

public abstract class MountainFactory {
    public abstract MountainCave getMountainTop();
}
