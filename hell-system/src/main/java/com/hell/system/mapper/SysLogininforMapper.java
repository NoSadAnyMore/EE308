package com.hell.system.mapper;

import java.util.List;
import java.util.Map;

import com.hell.system.domain.SysLogininfor;
import org.apache.ibatis.annotations.Select;

/**
 * 系统访问日志情况信息 数据层
 * 
 * @author hell
 */
public interface SysLogininforMapper
{
    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量删除系统登录日志
     * 
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     * 
     * @return 结果
     */
    public int cleanLogininfor();


    @Select("SELECT a.date,count(u.info_id) as count from (\n" +
            "SELECT \n" +
            "    DATE_FORMAT(DATE_ADD(DATE_SUB(CURDATE(), INTERVAL DAY(CURDATE())-1 DAY), INTERVAL t.n DAY), '%Y-%m-%d') AS date\n" +
            "FROM \n" +
            "    (SELECT 0 AS n UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 \n" +
            "     UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9\n" +
            "     UNION ALL SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14\n" +
            "     UNION ALL SELECT 15 UNION ALL SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19\n" +
            "     UNION ALL SELECT 20 UNION ALL SELECT 21 UNION ALL SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24\n" +
            "     UNION ALL SELECT 25 UNION ALL SELECT 26 UNION ALL SELECT 27 UNION ALL SELECT 28 UNION ALL SELECT 29\n" +
            "     UNION ALL SELECT 30) AS t\n" +
            "WHERE \n" +
            "    DATE_ADD(DATE_SUB(CURDATE(), INTERVAL DAY(CURDATE())-1 DAY), INTERVAL t.n DAY) <= CURDATE()) a\n" +
            "\t\tLEFT JOIN \n" +
            "    sys_logininfor u ON DATE(u.login_time) = a.Date\n" +
            "GROUP BY \n" +
            "    a.Date\n" +
            "ORDER BY \n" +
            "    a.Date;\n" +
            "\t\t\n" +
            "\t\t\n")
    List<Map<String,Integer>> getMonthLogin();
}
