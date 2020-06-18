package inn.mroyek.movieappcleanarchitecture.abstraction

abstract class Mapper<in I, out O> {
    abstract fun map(input: I): O
}