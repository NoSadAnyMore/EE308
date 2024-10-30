package com.hell.system.service.impl;
import com.hell.common.core.domain.entity.SysUser;
import com.hell.common.utils.DateUtils;
import com.hell.system.domain.SysLogininfor;
import com.hell.system.mapper.ComUserAccountFlowMapper;
import com.hell.system.mapper.SysLogininforMapper;
import com.hell.system.mapper.SysUserMapper;
import com.hell.system.service.IHomeService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 首页数据
 * 
 * @author hell
 */
@Service
public class HomeServiceImpl implements IHomeService
{

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private SysLogininforMapper logininforMapper;

    @Resource
    private ComUserAccountFlowMapper  accountFlowMapper;


    @Override
    public Map getData() {
        Map<String,Object> resultMap =new HashMap();
        SysUser user =new SysUser();
        SysLogininfor logininfor =new SysLogininfor();
        //平台总金币
        int total=accountFlowMapper.getTotal();
         resultMap.put("totalAccount",total);
        //当日注册
        user.setParams(getDate(1));
        resultMap.put("todayUser",getUser(user));
        //当日登录
        logininfor.setParams(getDate(1));
        resultMap.put("todayLogin",getLogin(logininfor));

        //7日注册
        user.setParams(getDate(7));
        resultMap.put("sevenUser",getUser(user));
        //7日登录
        logininfor.setParams(getDate(7));
        resultMap.put("sevenLogin",getLogin(logininfor));


        //当月注册
        List<Map<String,Integer>> monthUser= userMapper.getMonthUser();
        resultMap.put("monthUser",monthUser);
        //当月登录
        List<Map<String,Integer>> monthLogin= logininforMapper.getMonthLogin();
        resultMap.put("monthLogin",monthLogin);

        return resultMap;
    }

    /**
     * 获取数据 时间区间 返回map beginTime  endTIme
     * type 1当日  7七日  30 当月
     * */
    public Map<String ,Object> getDate(Integer type){
        Map<String,Object> map=new HashMap<>();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (type == 1) { // 当日
            map.put("beginTime", now.format(formatter));
            map.put("endTime", now.format(formatter));
        } else if (type == 7) { // 七日
            map.put("beginTime", now.minusDays(6).format(formatter));
            map.put("endTime", now.format(formatter));
        } else if (type == 30) { // 当月
            map.put("beginTime", now.withDayOfMonth(1).format(formatter));
            map.put("endTime", now.format(formatter));
        }

        return map;
    }


    public int getUser(SysUser user){
       List<SysUser> users = userMapper.selectUserList(user);
       if (null !=users ){
           return users.size();
       }else{
           return 0;
       }
    }
    public int getLogin(SysLogininfor logininfor){
      List<SysLogininfor> logininfors  = logininforMapper.selectLogininforList(logininfor);
        if (null !=logininfors ){
            return logininfors.size();
        }else{
            return 0;
        }
    }
}
