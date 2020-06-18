package inn.mroyek.movieappcleanarchitecture.abstraction

abstract class UseCase<out T> {
    abstract suspend operator fun invoke(): T
}