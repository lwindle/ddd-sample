DDD 规范
转至元数据结尾
项目结构
- projectName 项目名  
    - base  maven module  业务逻辑实现 领域逻辑、数据持久化、基础设施、事务、远程接口的具体实现逻辑 等等。
    - client  maven module  dubbo 远程接口，consumer 需要用到的接口、数据对象、常量类、等等。
    - web maven module  SpringBoot 启动类 如果对外暴露Http接口，Controller 类会放在 web module。
DDD 包结构
base
- interfaces 领域业务的入口
    - facade.impl 远程接口的实现
    - job 定时任务
    - listener 事件监听 
- application 应用层
    - service  简单的一层，做一些不在领域层的操作，比如日志、限流等等切面操作。没有业务逻辑。
- domain 领域层
    - entity  领域对象，领域业务实现。对象之间明确了关系（包含、依赖），可以在一个高层级的领域对象上更新，不需要用到service。
    - factory 构造领域对象，领域对象被访问，需要通过 factory 构建。
    - repository  领域资源库，Dao 接口抽象。
    - service 领域层的服务，领域对象本身不能关联完成业务操作的，需要 service 来组合一个完整的业务流程。不是必须。
- infrastructure 基础设置层，业务无关，系统层面的通用功能。
    - mq 消息队列
    - aop 统一切面，异常、日志
    - config 配置
    - utils 工具类
    - annotation 注解
client
- domain 领域相关
    - dataObject 持久层对象
    - events 领域事件对象
    - constant  常量类
- interfaces
    - dto 远程接口数据传输对象
    - facade 暴露远程接口
web
- controller 领域入口的一种
- vo 和页面的交互对象放在这里面，入参和返回参数。
调用关系
domain <---- application <---- interfaces
  |               |                 |
  |               |                 |
  |               |                 |
infrastructure
规则
说明：包结构里的解释说明也是规则的一部分，此处列出上面没有提到的。
Dao 的更新必须封装在其对应的领域对象中，更新操作都是通过领域对象，不应该有其他入口。
domain 层不依赖外层
domain 层可以依赖其他系统的facade，不能依赖系统自己的 facade。
application.service 类命名，需要加上App的标示，比如 UserAppService
调用链路 controller 层必须经过 application.service, application.service 可以直接调用 domain.entity，也可以调用 domain.service
校验判断能在领域层公用的，放在领域对象中，不能通用的放在各自的外层。
字段不一致的对象转换，建一个 assembler 包，用来转换对象。
interfaces 调用必须经过 application.service
client 包路径与 base 包路径保持一致。
常量类都放在 client 包里
查询类请求，application.service 直接访问 repository 数据源，构建好数据返回给客户端，不需要经过 domain 层。
名词解释
DO 持久层对象，领域对象更新、持久化；从资源库（数据库）查询出来。无论是在 base、client，都只能定义在 domain 包里面。
BO 业务对象，当前项目内，领域之间的传递和接受的对象。XXXQuery, XXXCmd。
VO 视图层对象，web module 定义的包，和前端交互的对象，入参对象带后缀 Req，返回参数对象后缀带 Resp。
DTO 数据传输对象，方法的返回参数。不强制定义。
Command 对象，命令操作对象，写请求对象。
POJO 简单 Java 对象，只有属性和其 getter、setter 方法的对象（ DO、VO、DTO 对象的统称）