package example

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class JsonSpec extends Specification {

  "can deserialize json into a VaultError even with an empty errors array" in new context {
    val vaultErrorsJson = """{"errors":[]}"""
    JsonUtils.fromJson[VaultError](vaultErrorsJson).toOption must beSome(VaultError(errors = List()))
  }

  trait context extends Scope
}
