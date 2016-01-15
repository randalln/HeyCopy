databaseChangeLog = {

	changeSet(author: "rnorviel (generated)", id: "1394560372778-1") {
		addColumn(tableName: "setting") {
			column(name: "skey", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394560372778-2") {
		addColumn(tableName: "setting") {
			column(name: "sval", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "rnorviel (generated)", id: "1394560372778-3") {
		dropColumn(columnName: "k", tableName: "setting")
	}

	changeSet(author: "rnorviel (generated)", id: "1394560372778-4") {
		dropColumn(columnName: "v", tableName: "setting")
	}
}
