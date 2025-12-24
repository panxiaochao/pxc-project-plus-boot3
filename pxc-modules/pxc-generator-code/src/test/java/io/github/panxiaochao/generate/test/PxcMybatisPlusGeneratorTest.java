package io.github.panxiaochao.generate.test;

import io.github.panxiaochao.generate.enums.GenerateDbType;
import io.github.panxiaochao.generate.tool.PxcMybatisPlusGeneratorTools;

/**
 * {@code PxcMybatisPlusGeneratorTest}
 * <p>
 * description:
 *
 * @author Lypxc
 * @since 2023-02-15
 */
public class PxcMybatisPlusGeneratorTest {

	public static void main(String[] args) {
		PxcMybatisPlusGeneratorTools.builder()
			// .jdbcUrl("jdbc:mysql://134.98.6.21:9200/kids?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
			.jdbcUrl(
					"jdbc:mysql://127.0.0.1:3308/pxc-system-plus?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
			.username("root")
			.password("123456")
			.dbType(GenerateDbType.MYSQL)
			// .outputDir("E:/work_2023/test")
			.outputDir("/Users/lypxc/Documents/project_my/pxc-project-plus-boot3/pxc-modules/pxc-code")
			.parent("io.github.panxiaochao.system")
			.moduleName("")
			.entityName("po")
			// .logicDeleteColumnName("deleted")
			.insertFields("create_at", "create_by", "update_at", "update_by")
			.updateFields("update_at", "update_by")
			.logicDeleteColumnName("is_delete")
			.includes("sys_area", "sys_dict", "sys_dict_item", "sys_job", "sys_log_login", "sys_log_operate",
					"sys_menu", "sys_org", "sys_param", "sys_post", "sys_role", "sys_role_menu", "sys_tenant",
					"sys_tenant_package", "sys_tenant_package_menu", "sys_tenant_user", "sys_user", "sys_user_auths",
					"sys_user_org", "sys_user_post", "sys_user_role")
			.build();
	}

}
