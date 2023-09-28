package oops


object L22_Enums {
  /*enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit = {
      if (this == Permissions.READ) println("opening document...")
      else println("reading not all")
    }

  }


  val somePermissions: Permissions = Permissions.READ

  enum PermissionsWIthBits(bits: Int) {
    case READ extends PermissionsWIthBits(4)
    case WRITE extends PermissionsWIthBits(2)
    case EXECUTE extends PermissionsWIthBits(1)
    case NONE extends PermissionsWIthBits(0)
  }

  object PermissionsWIthBits {
    def fromBits(bits: Int): PermissionsWIthBits = // whatever
      PermissionsWIthBits.NONE
  }

  val somePemissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWIthBits.values
  val readPermission : Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePemissionsOrdinal)
  }*/
}
