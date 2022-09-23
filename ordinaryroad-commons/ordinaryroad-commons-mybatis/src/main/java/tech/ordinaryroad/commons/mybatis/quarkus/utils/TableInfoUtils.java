package tech.ordinaryroad.commons.mybatis.quarkus.utils;

import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mjz
 * @date 2022/9/23
 */
public class TableInfoUtils {

    /**
     * 获取DO类某个属性的数据库字段名
     *
     * @param clazz    Class
     * @param property 属性名
     * @return 字段名
     */
    public static String getTableFieldColumn(Class<?> clazz, String property) {
        List<TableFieldInfo> collect = TableInfoHelper.getTableInfo(clazz)
                .getFieldList()
                .stream().filter(item -> item.getProperty().equals(property))
                .collect(Collectors.toList());
        assert collect.size() == 1;
        return collect.get(0).getColumn();
    }

}
