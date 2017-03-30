package example {
  trait VaultModel
  case class VaultError(errors: List[String]) extends Throwable with VaultModel {
    override def getMessage() = {
      errors.mkString(", ")
    }
  }
}
