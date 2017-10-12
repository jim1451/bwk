package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-02.
 */

public class OnlineDetailsResult implements Serializable {

    /**
     * chapterList : [{"chapterId":177,"chapterName":"第一章 导学","courseId":51,"description":"第一章 导学","sectionList":[{"chapterId":177,"free":1,"remark":"","sectionContent":"<p style=\"text-indent:2em;\">\r\n\t<strong>一、教师资格证概述 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2001年，我国开始全面实施教师资格制度。这对于把好教师职业入口关、拓宽教师来源渠道、促进教师专业化、提高教师地位等发挥了重要的作用。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t随着我国经济社会和教育事业的快速发展，社会对教师的资质和品行提出了更高要求，开展中小学和幼儿园教师资格考试改革已经成为加强教师队伍建设的一项重要而紧迫的任务。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t此次改革政策性强，涉及面广、情况复杂且关系到教师资格申请人的切身利益，教育部决定2011年在浙江、湖北两省开展教师资格证考试改革试点工作，经过试点取得经验再于全国展开，迄今为止，考试已经进行了十次。2016年起，青海、四川、广东、重庆、辽宁、黑龙江、天津、云南也纳入了全国统考范围。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t截止2016年上半年，只有新疆、内蒙古、西藏三个地区没有纳入到全国统考范围。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>二、教师资格考试改革试点的目标与任务 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t建立国家教师资格标准，改进考试内容，强化职业道德、心理素养、教育教学能力和专业发展潜质，改革考试形式，加强考试管理，完善考试评价，引导教师教育改革，严把教师职业入口关，结合现在教师公开招聘制度的改革，形成\u201c国标、省考、县聘、校用\u201d的教师准入和管理制度。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>三、教师资格考试改革前和改革后对比<\/strong> \r\n<\/p>\r\n<table width=\"90%\" border=\"2\" cellpadding=\"0\" cellspacing=\"0\">\r\n\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>具体内容 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>改革前 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>改革后 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试形式 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t各省自主命题\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t全国统考\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考生范围 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t非师范类学生与其他社会人员\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t师范生纳入全国统考范围\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试科目 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t教育学<br />\r\n心理学\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t综合素质<br />\r\n教育教学知识与能力<br />\r\n学科教育知识与能力\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试方式 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试+面试\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t机考+笔试+面试\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试内容 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t指定的教育学、心理学参考教材\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t不指定统一的参考用书\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>成绩年限 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试成绩长期有效\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试单科成绩有效期2年\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>报考资格 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t大专以上资格即可报考\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t多数考试需要本科以上学历\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>发证时间 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t教学能力测试通过\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t部分科目增加教学实习经验\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>证书有效期 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t未规定\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t有效期3年，5年一周期定期注册\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t<\/tbody>\r\n<\/table>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>注<\/strong>：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、教师资格证书长期有效。目前部分地区正在试点定期注册，该注册仅限于已进入教师岗位的持证者，要求5年一周期进行注册，未注册通过的取消教师资格。未进入教师岗位的持证者不受定期注册影响，证书依然有效，但一旦从事教学工作后则需进行定期注册；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教师资格证笔试单科成绩有效期为2年(登陆成绩查询系统即可查询各科具体失效日期)，有效期内可直接报考面试，过期需重新报考；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、教师资格证笔试、面试均合格后可获得《中小学教师资格考试合格证明》，该证明有效期为3年(登陆成绩查询系统即可查询具体失效日期)，有效期内可直接申请认定，过期不能认定需重新考试。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>四、教师资格证考试的类型 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t幼儿园教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t小学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t初级中学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高级中学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中等职业学校教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中等职业学校实习指导教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高等学校教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t注：根据《中华人民共和国教师法》第十三条 普通高等学校的教师资格由国务院或者省、自治区、直辖市教育行政部门或者由其委托的学校认定。高校教师资格证书只允许大学教师或已经签协议在大学工作的聘任制教师办理。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>五、考试方式 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t考试分为笔试和面试两部分。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t幼儿园和小学类别的所有笔试科目采用机考，其余科目采用纸笔考试。笔试各科考试时间均为120分钟。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t目前全国各地区只有上海的幼儿园教师资格考试的笔试科目是全部采用机考，我国其他地区的幼儿园、小学、中学类别还是统一采取笔试的方式。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t面试采用结构化面试、情景模拟等方法，考生通过抽题、备课、试讲、答辩等方式进行。使用教育部考试中心统一研制的面试测评系统。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>六、中学教师资格考试的科目 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t报考初级中学、高级中学、中职文化课教师的考生，笔试分为三个科目：科目一是《综合素质》，科目二是《教育知识与能力》，科目三是《学科知识与教学能力》，面试是《教育教学实践能力》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t初级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、历史与社会、科学等15个学科。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、通用技术等14个学科。\r\n<\/p>","sectionId":447,"sectionName":"第一节  教师资格证考试介绍","sectionType":1,"sectionUrl":"attached/section/447.html","seq":4470,"testId":447,"timeLength":0},{"chapterId":177,"free":1,"remark":"","sectionContent":"<p style=\"text-indent:2em;\">\r\n\t<strong>一、考试形式 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t改革后，申请教师资格的人员，将由省里自行组织考试改为参加全国统一组织的教师资格考试，即\u201c省考\u201d升为\u201c国考\u201d。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第一、考试内容\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中学和中职文化课教师增加一个考试科目，合计三门，分别为科目一《综合素质》、科目二《教育知识与能力》和科目三《学科知识与教学能力》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《学科知识与教学能力》因个人选择的学科不同，考试内容也不同。主要考核个人的专业学历和相对应的教学学科的专业知识及其教学能力，考生应根据自己的需要选择对应的学科。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第二、考试难度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t从2015年开始，教师资格考试实行全国统考，由教育部统一制定考试标准和考试大纲，组织笔试和面试试题，并建立试题库，考试将按照高考的要求来组织，难度将会大大增加。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第三、考试方式\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t只有上海的幼儿园教师资格考试的笔试科目是全部采用机考，我国其他地区的幼儿园、小学、中学类别还是统一采取笔试的方式。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第四、考试题型\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t不同专业学历所报考学科的考试题型，评分标准都有所不同，同时也没有指定的教材，考生根据自己的需要自行选择教材进行复习。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第五、成绩年限\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t\u201c省考\u201d的笔试单科成绩有效期为1年，\u201c国考\u201d的笔试单科成绩有效期为2年，如有未通过科目请在下次笔试考试时报考未通过科目，如全部通过笔试科目则等待面试报名期间报考面试。这就意味着，考生第一次考出一门，还有一年半的时间考出其他科目。超过两年未考出资格证，原成绩作废。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t除了以上的不同之外，还有一个重大的变化就是，改革试点启动后，至2012年及以后入学的师范类专业学生，则必须参加国家教师资格证统考，这无疑加强了对师范类学生的专业要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t最后，改革后教师的入职门槛提高了，并且打破教师资格终身制，实行定期注册制度。可见，国家将通过改革对教师队伍，进行更加规范化的管理与限制。在公平的教育考试制度下，将会有更多的有志之才，通过自身努力，加入到广大的教师队伍中去。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>二、学习建议 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．初步感知，知识点梳理，形成感性经验。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《综合素质》课程考试涵盖学科的范围较广，包括职业理念、教育法律法规、教师职业道德、文化素养、教师基本能力等内容。只有按照考纲全面要求把握，才能以不变应万变。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．形成知识结构，体系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在初步感知的基础上对每个知识点的内容进行梳理和理解，吃透每个知识点，并对整个学科的知识体系和框架了然于胸，形成自己头脑中的知识结构。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3．加强理解记忆，巩固知识\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t进一步重复感知、记忆、可结合使用知识点和做练习题穿插进行的方式。对做错的题目进行纠错，并分析做错的原因，并重新回归知识点加强理解和记忆，以巩固知识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4．深入掌握并灵活运用知识，提高能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在学习时一定要紧扣考试大纲的要求去学习相关的知识,了解同一知识点的不同变式灵活运用，提高答题做题能力。\r\n<\/p>","sectionId":448,"sectionName":"第二节  注意事项","sectionType":1,"sectionUrl":"attached/section/448.html","seq":4480,"testId":448,"timeLength":0}],"seq":10},{"chapterId":180,"chapterName":"第二章 考试大纲","courseId":51,"description":"第二章 考试大纲","sectionList":[{"chapterId":180,"free":1,"remark":"","sectionContent":"<h1 style=\"text-align:center;\">\r\n\t第一节&nbsp; 考试目标\r\n<\/h1>\r\n<p style=\"text-indent:2em;\">\r\n\t主要考查申请教师资格人员的下列知识、能力和素养：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1.具有先进的教育理念。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.具有良好的法律意识和职业道德。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.具有一定的文化素养。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.具有阅读理解、语言表达、逻辑推理、信息处理等基本能力。\r\n<\/p>","sectionId":452,"sectionName":"第一节  考试目标","sectionType":1,"sectionUrl":"attached/section/452.html","seq":4520,"testId":452,"timeLength":0},{"chapterId":180,"free":1,"remark":"","sectionContent":"<h1 style=\"text-align:center;\">\r\n\t第二节&nbsp; 考试内容\r\n<\/h1>\r\n<p style=\"text-indent:2em;\">\r\n\t《综合素质》主要考查申请教师资格人员的知识、能力和素养，包括五个模块：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t模块一：职业理念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t模块二：教育法律法规\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t模块三：教师职业道德规范\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以上三个方面是关于教育方面的素养，以下两个内容是一般素养。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t模块四：文化素养\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t模块五：基本能力\r\n<\/p>","sectionId":453,"sectionName":"第二节  考试内容","sectionType":1,"sectionUrl":"attached/section/453.html","seq":4530,"testId":453,"timeLength":0},{"chapterId":180,"free":1,"remark":"","sectionContent":"<h1 style=\"text-align:center;\">\r\n\t第三节&nbsp; 考试要求\r\n<\/h1>\r\n<strong>(一)职业理念 <\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1．教育观\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解国家实施素质教育的基本要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t掌握在学校教育中开展素质教育的途径和方法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t依据国家实施素质教育的基本要求，分析和评判教育现象。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．学生观\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解\u201c人的全面发展\u201d的思想。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解\u201c以人为本\u201d的涵义，在教育教学活动中做到以学生的全面发展为本。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t运用\u201c以人为本\u201d的学生观，在教育教学活动中公正地对待每一个学生，不因性别、民族、地域、经济状况、家庭背景和身心缺陷等歧视学生。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t设计或选择丰富多样、适当的教育教学活动方式，因材施教，以促进学生的个性发展。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3．教师观\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解教师专业发展的要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具备终身学习的意识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在教育教学过程中运用多种方式和手段促进自身的专业发展。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解教师职业的责任与价值，具有从事教育工作的热情与决心。\r\n<\/p>\r\n<p>\r\n\t<strong>(二)教育法律法规 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．有关教育的法律法规\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解国家主要的教育法律法规，如《中华人民共和国教育法》、《中华人民共和国义务教育法》、《中华人民共和国教师法》、《中华人民共和国未成年人保护法》、《中华人民共和国预防未成年人犯罪法》《学生伤害事故处理办法》等。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解《国家中长期教育改革和发展规划纲要(2010-2020年)》的相关内容。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．教师权利和义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解教师的权利和义务，熟悉国家有关教育法律法规所规范的教师教育行为，依法从教。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t依据国家教育法律法规，分析评价教师在教育教学实践中的实际问题。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.学生权利保护\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解有关学生权利保护的教育法规，保护学生的合法权利。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t依据国家教育法律法规，分析评价教育教学活动中的学生权利保护等实际问题。\r\n<\/p>\r\n<p>\r\n\t<strong>(三)教师职业道德规范 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．教师职业道德\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解《中小学教师职业道德规范》(2008年修订)，掌握教师职业道德规范的主要内容，尊重法律及社会接受的行为准则。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解《中小学班主任工作条例》文件精神。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t分析评价教育教学实践中教师的道德规范问题。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．教师职业行为\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解教师职业行为规范的要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解教师职业行为规范的主要内容，在教育活动中运用行为规范恰当地处理与学生、学生家长、同事以及教育管理者的关系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在教育教学活动中，依据教师职业行为规范，爱国守法、爱岗敬业、关爱学生、教书育人、为人师表。\r\n<\/p>\r\n<p>\r\n\t<strong> (四)文化素养 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解中外历史上的重大事件。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解中外科技发展史上的代表人物及其主要成就。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解一定的科学常识，熟悉常见的科普读物，具有一定的科学素养。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解重要的中国传统文化知识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解中外文学史上重要的作家作品。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解一定的艺术鉴赏知识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解艺术鉴赏的一般规律，并能有效地运用于教育教学活动。\r\n<\/p>\r\n<p>\r\n\t<strong> (五)基本能力 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．信息处理能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有运用工具书检索信息、资料的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有运用网络检索、交流信息的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有对信息进行筛选、分类、管理和应用的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有运用教育测量知识进行数据分析与处理的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有根据教育教学的需要，设计、制作课件的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．逻辑思维能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t了解一定的逻辑知识，熟悉分析、综合、概括的一般方法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t掌握比较、演绎、归纳的基本方法，准确判断、分析各种事物之间的关系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t准确而有条理地进行推理、论证。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3. 阅读理解能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解阅读材料中重要概念的含义。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解阅读材料中重要句子的含义。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t筛选并整合图表、文字、视频等阅读材料的主要信息及重要细节。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t分析文章结构，把握文章思路。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t归纳内容要点，概括中心意思。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t分析概括作者在文中的观点态度。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t根据上下文合理推断阅读材料中的隐含信息。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.写作能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t掌握文体知识，能根据需要按照选定的文体写作。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t能够根据文章中心组织、剪裁材料。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有布局谋篇，安排文章结构的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t语言表达准确、鲜明、生动，能够运用多种修辞手法增强表达效果。\r\n<\/p>","sectionId":454,"sectionName":"第三节  考试要求","sectionType":1,"sectionUrl":"attached/section/454.html","seq":4540,"testId":454,"timeLength":0},{"chapterId":180,"free":1,"remark":"","sectionContent":"<h1 style=\"text-align:center;\">\r\n\t第四节&nbsp; 试卷结构与题型事例\r\n<\/h1>\r\n<strong>一、试卷结构 <\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t考试试题分三大类，即单项选择，材料分析及写作题。这些题型对考生的记忆要求不是很高，因此复习时不要求大家对教材原文死记硬背，而是要求能够理解，融会贯通，在掌握的基础上记住各内容的要点、关键词，也就是理解记忆。所以在听课时重在理解，在理解的过程中把握相应的内容。同时，听完课以后要求认真看书，反复领会，理解之后再记忆相应的内容。对教材的内容掌握到一定的程度之后再进行相应的练习。对练习题的态度要端正，一定要自己真正理解和掌握，不要死记硬背。\r\n<\/p>\r\n<div align=\"center\">\r\n\t<table width=\"90%\" border=\"2\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n\t\t<tbody>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t模&nbsp; 块\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t比&nbsp; 例\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"250\" valign=\"top\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t题&nbsp; 型\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t职业理念\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t15%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"250\" rowspan=\"4\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t单项选择题 <br />\r\n材料分析题\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t教育法律法规\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t10%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t教师职业道德规范\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t15%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t文化素养\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t12%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t基本能力\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t48%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"250\" valign=\"top\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t单项选择题 <br />\r\n材料分析题 <br />\r\n写&nbsp; 作&nbsp; 题\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td width=\"171\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t合&nbsp; 计\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"106\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t100%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t\t<td width=\"250\" valign=\"top\">\r\n\t\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t\t单 项 选 择 题 ： 约39%<br />\r\n非 选&nbsp; 择&nbsp; 题 ： 约61%\r\n\t\t\t\t\t<\/p>\r\n\t\t\t\t<\/td>\r\n\t\t\t<\/tr>\r\n\t\t<\/tbody>\r\n\t<\/table>\r\n<\/div>\r\n<p align=\"left\">\r\n\t<strong>二、题型示例 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（一）单项选择题\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）小明在课堂上突然大叫，有的同学也跟着起哄。下列处理方式，最恰当的一项是\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tA．马上制止，让小明站到讲台边\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tB．不予理睬，继续课堂教学\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tC．稍作停顿，批评训斥学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tD．幽默化解，缓和课堂气氛\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）\u201c五岳\u201d是我国的五大名山，下列不属于\u201c五岳\u201d的一项是\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tA．泰山&nbsp;&nbsp;&nbsp; B．华山&nbsp;&nbsp;&nbsp; C．黄山&nbsp;&nbsp;&nbsp; D．衡山\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t阅读下面文段，回答问题。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t子曰：\u201c学而不思则罔①，思而不学则殆②。\u201d（《论语·为政》）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t【注释】①罔：迷惑、糊涂。②殆：疑惑、危险。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）下列对孔子这段话的理解，不正确的一项是\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tA．在孔子看来，学和思二者不能偏废，主张学与思相结合。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tB．孔子指出了学而不思的局限，也道出了思而不学的弊端。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tC．光学习不思考会越学越危险，光思考不学习会越来越糊涂。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tD．孔子学与思相结合的思想，在今天仍有其值得肯定的价值。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（二）材料分析题\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t阅读下面材料，回答问题。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t学生王林在学校因同学给他起外号，将同学的鼻子打出了血。班主任徐老师给王林的爸爸打电话，让他下午到学校来。放学时，王林的爸爸刚来到校门口，等在那里的徐老师当着众人的面，第一句话就是：\u201c这么点儿大的孩子都管不好，还用我教你吗？\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t问题：请从教师职业道德规范的角度，对徐老师的做法进行评价。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（三）写作题\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t请以\u201c我为什么要当教师\u201d为题，写一篇论述文。要求观点明确，论述具体，条理清楚，语言流畅。不少于800字。\r\n<\/p>","sectionId":455,"sectionName":"第四节  试卷结构与题型事例","sectionType":1,"sectionUrl":"attached/section/455.html","seq":4550,"testId":455,"timeLength":0}],"seq":20},{"chapterId":400,"chapterName":"第三章 考点归纳：职业理念","courseId":51,"description":"第三章 考点归纳：职业理念","sectionList":[{"chapterId":400,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1.理解国家实施素质教育的基本要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.掌握在学校教育中开展素质教育的途径和方法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.依据国家实施素质教育的基本要求，分析和评判教育现象。\r\n<\/p>\r\n<p>\r\n\t<strong>一、理解国家实施素质教育的基本要求：<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）面向全体学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）促进学生全面发展\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）促进学生生动，活泼，主动发展\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）促进学生创新精神和实践能力的培养\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）着眼于学生的可持续发展\r\n<\/p>\r\n<p>\r\n\t<strong>二、掌握在学校教育中开展素质教育的途径和方法：<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1.途径有：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）树立素质教育理念，把握课改精神，实践新课程（基础教育新课程是实施素质教育的基本途径）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）学校管理，课外活动和班主任工作\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）举行德智体美并进的教育活动\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.方法有：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）提高教师队伍水平，最大限度的发挥教师的作用（主导性作用，更新教育理念，提高素养）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）将教育目的落实到教学之中\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）引导和调动学生学习的主动性和积极性\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）开展多种形式的实践活动\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）建立多层次，多样化的教学模式\r\n<\/p>\r\n<p>\r\n\t<strong>三、依据国家实施素质教育的基本要求，分析和评价教育现象<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、素质教育：素质教育是依据人的发展和社会发展的实际需要，以全面提高全体学生的基本素质为根本目的，以尊重学生个性，注重开发人的身心潜能，注重形成人的健全个性为根本特征的教育\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、为什么要实施素质教育？\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）实施素质教育是落实\u201c科教兴国\u201d战略的需要；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）实施素质教育是当今国际教育改革和发展的共同趋势；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）实施素质教育是我国基础教育改革和发展的需要；\r\n<\/p>","sectionId":1097,"sectionName":"第一节  教育观","sectionType":1,"sectionUrl":"attached/section/1097.html","seq":10970,"testId":1097,"timeLength":0},{"chapterId":400,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1.理解\u201c人的全面发展\u201d的思想。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.理解\u201c以人为本\u201d的涵义，在教育教学活动中做到以学生的全面发展为本。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.运用\u201c以人为本\u201d的学生观，在教育教学活动中公正地对待每一个学生，不因性别、民族、地域、经济状况、家庭背景和身心缺陷等歧视学生。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.设计或选择丰富多样、适当的教育教学活动方式，因材施教，以促进学生的个性发展。\r\n<\/p>\r\n<p>\r\n\t<strong>一、我国所倡导的学生观：<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以人为本和全面发展、理解\u201c人的全面发展\u201d的思想\r\n<\/p>\r\n<p>\r\n\t<strong>二、什么是\u201c人的全面发展\u201d<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t人的道德、体力和智力的全面、和谐、充分的发展\r\n<\/p>\r\n<p>\r\n\t<strong> 三、为什么人要全面发展<\/strong>（基本内容）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）人的发展与社会生活条件紧密联系；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）传统分工导致人的片面发展；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）科技革命为人类准备了全面发展的物质基础；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）社会主义是人的全面发展的制度条件；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）人的全面发展建立在人的劳动活动全面发展的基础上；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）人的全面发展的唯一途径是教育与生产相结合；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（7）人的全面发展包括人的素质和个性的全面发展\r\n<\/p>\r\n<p>\r\n\t<strong> 四、什么是\u201c以人为本\u201d<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t\u201c以人为本\u201d是一种肯定人的作用和地位，强调尊重人、解放人、依靠人和为了人的价值取向\r\n<\/p>\r\n<p>\r\n\t<strong>五、\u201c以人为本\u201d的具体含义：<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）人与自然的关系：在维护生态平衡的前提下满足人的生存需要；（2）人与社会的关系：在公平公正的前提下满足人的发展需要；（3）人与人的关系：在维护公平正义的前提下优质优酬、兼顾公平（4）人与组织的关系：在自愿与共享的前提下满足个人的发展需要\r\n<\/p>\r\n<p>\r\n\t<strong>六、\u201c以人为本\u201d的学生观<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）学生是完整的，具有独立意义的个体（2）学生是学习的主体（3）学生需要尊重（4）学生都有潜力\r\n<\/p>","sectionId":1098,"sectionName":"第二节  学生观","sectionType":1,"sectionUrl":"attached/section/1098.html","seq":10980,"testId":1098,"timeLength":0},{"chapterId":400,"free":0,"remark":"","sectionContent":"<strong> 考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1.了解教师专业发展的要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.具备终身学习的意识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.在教育教学过程中运用多种方式和手段促进自身的专业发展。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.理解教师职业的责任与价值，具有从事教育工作的热情与决心。\r\n<\/p>\r\n<p>\r\n\t<strong>一、教师专业发展的要求<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）必须学会学习，加强终身学习的意识和能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）培养和发展自己的反思能力，成为反思型教师\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）培养和强化创新精神和创新能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）重视交往与合作能力的培养\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）要成为课程教育教学的研究者\r\n<\/p>\r\n<p>\r\n\t<strong>二、教师应具备终身学习的意识<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）为什么要终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①新课程要求教师必须终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②教师自我实现必须终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③提升教学水平须坚持终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④提高教育创新精神须终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤终身学习是教师的职业责任\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑥教材改革要求教师必须终身学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）教师终身学习的可行性\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\ta教师学习的内容：①学习能力学习②专业知识学习③教育理论学习④信息技术学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tb教师终身学习的方法：①系统的终身学习②校本学习③成人教育④媒体学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tc教师终身学习在教学中的作用：①提高课堂教学效率②学校教育发展的需要③传播终身学习观念\r\n<\/p>\r\n<p>\r\n\t<strong>三、教师应促进自身的专业发展<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）培育学习能力，做学习型教师\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）培养反思能力，做反思型教师\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）培育创新精神，做创新型教师\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）培养合作能力，做伙伴型教师\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）培育科研能力，做研究型教师\r\n<\/p>\r\n<p>\r\n\t<strong> 四、全面提高教育教学质量<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）抓常规教育，培养良好习惯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）重情感教育，培养健全人格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）多媒体教学，激发学习兴趣\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）多联系实际，培养动手能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）多样化教学，强化主动学习\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）重因材施教，强化学困帮扶\r\n<\/p>\r\n<p>\r\n\t<strong> 五、如何提高教学成绩<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）讲方法：处理好师生关系\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）讲落实：监控好教学环节\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）讲思路：培养好学习习惯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）讲科学：发展好教研能力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t理解教师职业的责任与价值\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）教师职业的责任\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t教师的根本职责是培养社会主义新人，社会主义事业的建设者和接班人\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①学生全面发展的培养者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②民主师生关系的建立者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③学生学习过程的指导者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④教育信息的开发应用者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤学生健康心理的培育者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）教师职业的价值\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①教师是文化传递者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②教师是文明促进者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③教师是智慧开启者\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④教师是道德塑造者\r\n<\/p>","sectionId":1099,"sectionName":"第三节  教师观","sectionType":1,"sectionUrl":"attached/section/1099.html","seq":10990,"testId":1099,"timeLength":0}],"seq":4260},{"chapterId":401,"chapterName":"第四章 考点归纳：教育法律法规","courseId":51,"description":"第四章 考点归纳：教育法律法规","sectionList":[{"chapterId":401,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1.了解国家主要的教育法律法规，如《中华人民共和国教育法》《中华人民共和国义务教育法》《中华人民共和国教师法》《中华人民共和国未成年人保护法》《中华人民共和国预防未成年人犯罪法》《学生伤害事故处理办法》等。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.了解《国家中长期教育改革和发展规划纲要(2010-2020年)》的相关内容。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中国教育法律法规体系\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1980年《中华人民共和国学位条例》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1986年《中华人民共和国义务教育法》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1993年《中华人民共和国教师法》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1995年《中华人民共和国教育法》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1996年《中华人民共和国职业教育法》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1998年《中华人民共和国高等教育法》\r\n<\/p>\r\n<p>\r\n\t<strong>一、中华人民共和国教育法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、1995年3月18日第八届全国人大第三次会议通过1995年3月18日中华人民共和国主席令第45号公布自1995年9月1日起施行\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、《教育法》是我国教育工作的根本大法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、《教育法》的颁布，标志着我国教育工作进入全面依法治教的新阶段\r\n<\/p>\r\n<p>\r\n\t<strong>二、中华人民共和国义务教育法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、1986年4月12日通过，1986年7月1日实施；2006年6月29日修订，2006年9月1日实施\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、义务教育是根据法律规定，适龄儿童和青少年都必须接受，国家、社会、家庭必须予以保证的国民教育。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、义务教育的实质是国家依照法律的规定对适龄儿童和青少年实施的一定年限的强迫教育的制度。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、义务教育又称强迫教育和免费义务教育\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、义务教育具有强制性、免费性、普及性的特点\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、我国义务教育法规定的义务教育年限为九年\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、公益性：明确规定\u201c不收学费、杂费\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、统一性：制定统一的义务教育阶段教科书设置标准、教学标准、经费标准、建设标准、学生公用经费的标准等等。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、强制性：让适龄儿童、少年接受义务教育是学校、家长和社会的义务，谁违反谁就要受到法律的惩处。\r\n<\/p>\r\n<p>\r\n\t<strong> 三、中华人民共和国教师法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、用法律来维护教师的合法权益，保障教师待遇和社会地位的不断提高；加强教师队伍的规范化管理，确保教师队伍整体素质不断优化和提高。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、1993年10月31日中华人民共和国主席令15号颁布，1994年1月1日正式实施\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、教师法规定每年9月10日为教师节\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、教师法规定教师的平均工资水平应当不低于或者高于国家公务员的平均工资水平，并逐步提高。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、教师法确定正常晋级增薪制度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、法律还规定，教师不准体罚学生，违者究责\r\n<\/p>\r\n<p>\r\n\t<strong> 四、中华人民共和国未成年人保护法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、制定：1991年9月4日七届人大21次会议通过，1992年1月1日执行\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、修订：十届人大25次会议于2006年12月29日修订通过，并于2007年6月1日开始实施\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）学校不得违法开除未成年学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）教师不能在校内吸烟\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）突发事件先救未成年人\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）父母不可偷看孩子日记\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）法院可剥夺父母监护权\r\n<\/p>\r\n<p>\r\n\t<strong> 五、中华人民共和国预防未成年人犯罪法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第九届人大10次会议于1999年6月28日通过，自1999年11月1日起施行\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）明确禁止旷课、夜不归宿、打架斗殴、赌博等不良行为\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）不得脱离监护\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）严重不良行为的矫治\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）不良少年的工读制度\r\n<\/p>\r\n<p>\r\n\t<strong> 六、学生伤害事故处理办法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2002年3月26日经教育部部务会议讨论通过，自2002年9月1日起施行\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）目的：积极预防、妥善处理在校学生伤害事故，保护学生、学校的合法权益\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）适用范围：在学校实施的教育教学活动或者学校组织的校外活动中，以及在学校负有管理责任的校舍、场地、其他教育教学设施、生活设施内发生的，造成在校学生人身损害后果的事故的处理。\r\n<\/p>\r\n<p>\r\n\t<strong> 七、《国家中长期教育改革和发展规划纲要（2010-2020年）》<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、学前教育纳入规划，破解城乡\u201c入园难\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、缩小校际差距，解决择校难题\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、进城务工人员随迁子女，有望在当地参加升学考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、减轻中小学生课业负担给学生更多发展空间\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、逐步实行中等职业教育免费制度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、推进政校分开管办分离，逐步取消高校行政级别\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、高校分类入学考试，让不同的人有多重选择\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、教师工资不低于公务员，保障教师安心从教\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、在中小学设置正高级职务（职称）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、纠正对民办学校歧视，鼓励出资办学\r\n<\/p>\r\n<p>\r\n\t<strong>八、纲要的三大战略：<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、基本实现教育现代化\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、基本形成学习型社会\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、进入人力资源强国的行列\r\n<\/p>","sectionId":1102,"sectionName":"第一节  我国的教育法律法规","sectionType":1,"sectionUrl":"attached/section/1102.html","seq":11020,"testId":1102,"timeLength":0},{"chapterId":401,"free":0,"remark":"","sectionContent":"<strong> 考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1.理解教师的权利和义务，熟悉国家有关教育法律法规所规范的教师教育行为，依法从教。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.依据国家教育法律法规，分析评价教师在教育教学实践中的实际问题。\r\n<\/p>\r\n<p>\r\n\t<strong>一、教师权利的内涵<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、含义：教师依法享有的某种权能和利益\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教师的权利：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）要求他人遵守教师法等法律或履行法律义务的请求权；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）按照自己的自由意志做出的教师法等法律所赋予的积极行为权；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）受侵害时向国家机关申请强制执行权\r\n<\/p>\r\n<p>\r\n\t<strong>二、教师的基本权利<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、教师的公民权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）政治权利\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）宗教信仰权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）平等权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）人身权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）文化教育权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）经济权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（7）监督权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教师的职业权利\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）教育教学权：进行教育教学活动，开展教育教学改革和实验；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）学术研究权：从事科学研究，学术交流，参加专业的团体，在学术活动中充分发表意见；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）指导评价权：指导学生学习和发展，评定学生品行和学业成绩；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）报酬待遇权：按时获取工资报酬，享受国家规定的福利待遇以及寒暑假带薪休假；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）参与管理权：对学校教育教学，管理工作和教育行政部门的工作提出意见和建议，通过教职工代表大会或者其他形式，参与学校的民主管理；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）进修培训权：参加进修或者其他方式的培养\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、新《义务教育法》关于教师权利的规定\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）各级政府保障义务教育教师工资福利和社会保险待遇\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）义务教育教师的平均工资水平不得低于当地公务员\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）义务教育阶段的特殊教育教师享有补助津贴\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、教师义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t定义：教师依据《教育法》、《教师法》及其他法律法规，从事教育教学工作而必须履行的责任\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t表现形式：（1）积极义务（2）禁止性义务（3）义务人侵犯他人权利和利益时，接受国家强制力保障其义务的履行\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、教师的基本义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）拥护国家统一和全国各民族团结的义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）遵纪守法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）维护国家安全、荣誉和利益的义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）保卫祖国和依法服兵役的义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）依法纳税义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、教师的基本义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）遵纪守法：遵守宪法，法律和职业道德，为人师表；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）履行教育教学职务：贯彻国家教育方针，遵守规章制度，执行学校的教学计划，履行教师聘约，完成教育教学工作任务；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）对学生进行思想政治教育：对学生进行宪法所确定的基本原则的教育和爱国主义，民主团结教育，法制教育以及思想品德，文化，科学技术教育，组织带领学生开展有意义的社会活动；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）尊重学生：关心爱护学生，尊重学生人格，促进学生在智德体美等方面全面发展\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）保护学生合法权益：制止有害于学生的行为或者其他侵犯学生合法权益的行为，批评和抵制有害于学生健康成长的现象；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）提高水平：不断提高思想觉悟和教育教学水平\r\n<\/p>","sectionId":1105,"sectionName":"第二节  教师权利和义务","sectionType":1,"sectionUrl":"attached/section/1105.html","seq":11050,"testId":1105,"timeLength":0},{"chapterId":401,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1.了解有关学生权利保护的教育法规，保护学生的合法权利。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.依据国家教育法律法规，分析评价教育教学活动中的学生权利保护等实际问题。\r\n<\/p>\r\n<p>\r\n\t<strong>一、学生权利<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、参加教育教学权：（1）参加教育教学活动权（2）使用教学设施权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、生存权利\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、人生权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、获得经济资助权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、获得学业证书权（1）获得公正评价权；（2）获得学业证书\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、申诉起诉权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、法定其他权\r\n<\/p>\r\n<p>\r\n\t<strong> 二、教育教学活动中的学生权利保护<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、教师保护学生的人身安全：（1）危险时教师挺身而出（2）教师须尽到保护义务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教师要尊重学生的受教育权：（1）不得随意剥夺学生上课权（2）不得随意缺课\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、教师要尊重学生的人格：（1）不能强迫学生做有损人格尊严的事（2）不能侮辱、谩骂学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、教师要尊重学生的生命健康权：（1）不能体罚或变相体罚学生（2）不得以其他方式侵犯学生生命健康权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、教师要尊重学生的人身自由权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、教师不得侵犯学生财产权\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、教师要尊重学生的隐私权：（1）不要随意泄露学生隐私（2）不得随意翻看学生物品\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、教师要注意保护自身权益\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、受教育者的权利\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）参加教育教学计划安排的各种活动，使用教学设施，设备和图书资料\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）按照国家的有关规定获得奖学金，助学金，贷学金\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）在学业成绩和品行上获得公正评价，完成规定的学业后获得相应的学业，学位证书\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）对学校给予的处分不服向有关部门提出申诉，对学校，教师侵犯其人身权，财产权等合法权益，提出申诉或者依法提起诉讼\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、受教育者的义务：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）遵守法律法规\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）遵守学生行为规范，尊敬师长，养成良好的思想品德和行为习惯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）努力学习完成规定的学习任务\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）遵守所在学校或者其他教育机构的管理制度\r\n<\/p>","sectionId":1107,"sectionName":"第三节  学生权利保护","sectionType":1,"sectionUrl":"attached/section/1107.html","seq":11070,"testId":1107,"timeLength":0}],"seq":4270},{"chapterId":402,"chapterName":"第五章 考点归纳：教师职业道德规范","courseId":51,"description":"第五章 考点归纳：教师职业道德规范","sectionList":[{"chapterId":402,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1.了解《中小学教师职业道德规范》（2008年修订），掌握教师职业道德规范的主要内容，尊重法律及社会接受的行为准则。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.理解《中小学班主任工作条例》文件精神。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.分析评价教育教学实践中教师的道德规范问题。\r\n<\/p>\r\n<p>\r\n\t<strong>一、《中小学教师职业道德规范》中教师的职业道德规范<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、爱国守法----教师职业的基本要求\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、爱岗敬业----教师职业的本质要求\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、关爱学生----师德的灵魂\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、教书育人----教师的天职\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、为人师表----教师职业的内在要求\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、终身学习----教师专业发展的不竭动力\r\n<\/p>\r\n<p>\r\n\t<strong> 二、《中小学班主任工作条例》<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t四大亮点\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）明确了班主任的工作量：另加教师工作量标准的一半\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）提高了班主任的经济待遇\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）保证班主任教育学生的权力\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）强调班主任在学校工作中的重要地位\r\n<\/p>","sectionId":1108,"sectionName":"第一节  教师职业道德","sectionType":1,"sectionUrl":"attached/section/1108.html","seq":11080,"testId":1108,"timeLength":0},{"chapterId":402,"free":0,"remark":"","sectionContent":"<strong> 考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1.了解教师职业行为规范的要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.理解教师职业行为规范的主要内容，在教育活动中运用行为规范恰当地处理与学生、学生家长、同事以及教育管理者的关系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.在教育教学活动中，依据教师职业行为规范，爱国守法、爱岗敬业、关爱学生、教书育人、为人师表。\r\n<\/p>\r\n<p>\r\n\t<strong>一、教师职业行为规范<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、思想行为规范\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教学行为规范\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、人际行为规范\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、仪表行为规范\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、语言行为规范\r\n<\/p>\r\n<p>\r\n\t<strong>二、教师需处理的几大关系<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（一）师生关系：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1.师生平等（建立平等的师生关系对老师的要求）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）更新教育观念；（①更新教学观②更新知识观③正确确立\u201c平等者中的首席\u201d）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）热爱尊重学生，确立民主观念，强化师生平等意识；严格要求学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）重视学生独立性、能动性和主体性的发挥；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）提高自身素质，改进交往策略\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.公平对待每一个学生（①一视同仁，正视差异②体谅和宽容③给学生提供多样的发展机会）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.宽容学生的缺点（①认识上的宽容②态度上的宽容③时间上的宽容④条件上的宽容⑤要求上的宽容⑥处理上的宽容）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.慎用惩戒；拒绝体罚\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5.严格要求学生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（二）教师与家长的关系（怎样处理好教师与家长的关系？）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）建立平等关系（2）良好的沟通习惯（3）换位思考\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（三）教师与同事的关系\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t交往技巧：（1）时常给予微笑和赞美（2）学会调控自己的情绪（3）积极主动地交往\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（四）教师与领导的关系\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）了解领导的需要：自尊的需要·成就的需要·交往的需要\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）争取领导的支持：尊重领导，相信领导·努力工作，做出成绩·主动沟通，争取支持\r\n<\/p>","sectionId":1109,"sectionName":"第二节  教师职业行为","sectionType":1,"sectionUrl":"attached/section/1109.html","seq":11090,"testId":1109,"timeLength":0}],"seq":4280},{"chapterId":403,"chapterName":"第六章 考点归纳：教师的文化素养","courseId":51,"description":"第六章 考点归纳：教师的文化素养","sectionList":[{"chapterId":403,"free":0,"remark":"","sectionContent":"<strong>一、原始社会<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1、原始人群\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）元谋人：已知中国境内最早的人类，距今170万年\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）蓝田人：距今80万年\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）北京人：距今50万年，已使用天然火\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、氏族社会：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）母系氏族：仰韶文化、河姆渡文化--\u201c彩陶文化\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）父系氏族：龙山文化、大汶口文化----\u201c黑陶文化\u201d\r\n<\/p>\r\n<p>\r\n\t<strong>二、奴隶社会<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、夏朝：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）夏朝：大禹之子夏启破禅让而开世袭之先河，建中国第一个奴隶制国家\u201c夏朝\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）商汤打败夏桀，夏朝灭\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）夏历成为我国最早的历法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、商朝：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）汤建商，武王灭纣\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）商已有文字，甲骨文可证\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、周朝\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）西周\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中国奴隶社会的鼎盛时期\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t周礼：吉、凶、军、宾、嘉\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t宗法制度：族制系统\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）东周\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t春秋（奴隶社会）：公元前770-公元前475，周平王迁都洛邑，史称东周，春秋开始，有春秋五霸：齐桓公、宋襄公、晋文公、楚庄王、秦穆公\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t战国（封建社会）：公元前475-公元前221年，战国七雄：齐、楚、燕、韩、赵、魏、秦\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t商鞅变法：秦孝公用商鞅变法：废田亩、建县制\r\n<\/p>\r\n<p>\r\n\t<strong>三、封建社会<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、秦朝（公元前221-公元前206年）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）秦王嬴政公元前221年灭六国统一中原\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）统一度量衡、文字、货币\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）北击匈奴：公元前215年蒙恬30万大军北伐\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）秦长城，西起临洮，东起辽东--万里长城\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）南统百越\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）陈胜吴广起义：史上第一次大规模农民起义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（7）秦王朝灭亡：公元前207年刘邦入关，秦王子婴投降\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、汉朝（公元前202-公元220年）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）西汉·202年楚汉之争项羽死，刘邦建汉，定都洛阳，后迁长安·汉初\u201c无为而治\u201d，休养生息，文景之治·汉武帝\u201c推恩令\u201d罢黜百家、独尊儒术\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）东汉·公元25年刘秀在鄗城称帝，史称东汉·东汉至219年，共历194年·光武中兴\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、秦汉时期的科技与艺术\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t数学：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）汉武帝时期《周髀算经》，勾股定律；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）汉朝《九章算术》，标志着我国古代数学完整体系的形成\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t天文：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）汉朝《汉书、五行志》有关于黑子的记录；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）长沙马王堆出土的《五星占》是我国最早的天文著作；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）汉安帝时，张衡浑天仪，132年又发明了候风地动仪\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t医学：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）秦汉时期建立中医体系；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）西汉：最早的药物学著作《神农本草经》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）东汉：最早的医学典籍《黄帝内经》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）东汉名医：华佗、张仲景造纸术：东汉和帝时\u201c蔡侯纸\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、三国两晋南北朝\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）200年，官渡之战，曹操战胜袁绍；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）208年，赤壁之战，孙刘联军破曹；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）三国鼎立\u201c魏蜀吴\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）西晋统一：265年司马炎宫廷政变，西晋建立；316年匈奴占领长安，西晋灭亡\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t文化与艺术\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）圆周率：南朝祖冲之求算出圆周率是3.1415926至3.1415927之间\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）463年祖冲之创立\u201c大明历\u201d，一年365天\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）贾思勰的《齐民要术》我国现存最完整农书、世界最早农书\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）马钧发明指南车，发明龙骨水车\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）郦道元《水经注》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、隋唐时期\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）581年杨坚废周静帝自立，隋朝建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）废九品中正制，设三省六部、创立科举\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）隋炀帝修建大运河\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）618年李渊篡隋，唐朝建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）贞观之治：唐太宗\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）唐高宗李治太宗之九子649年即位，是为唐高宗\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（7）683年高宗子李显即位，是为中宗\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（8）690年武则天称帝，是为中国唯一女皇帝\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（9）开元盛世：唐玄宗用姚崇、宋璟为相\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（10）安史之乱：755年节度使史思明、安禄山叛乱，唐朝名存实亡\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（11）875年王仙芝、黄巢起义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、五代辽宋夏金元\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）五代十国：后梁、后唐、后晋、后汉、后周\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）耶律阿保机：创制契丹文字，辽太祖\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）陈桥兵变：960年赵匡胤发动陈桥兵变，建立宋朝\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）元昊建夏：1038年元昊称大夏国皇帝，党项族\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）东北女真灭辽建金\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）1127年赵构称帝，是为宋高宗南宋\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（7）1206年，成吉思汗统一蒙古\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（8）1271年忽必烈改国号为元，1276年南宋灭亡\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（9）元朝是我国疆域最辽阔的朝代\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（10）行省制和宣政院（管佛教和藏族事务）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、明清时期：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）1368年朱元璋在应天称帝，明朝建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）明朝专制统治加强\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）郑和下西洋\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）李自成农民起义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（5）1644年明覆灭\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（6）1644年清军攻占北京，顺治逐步统一全国\r\n<\/p>\r\n<p>\r\n\t<strong>四、中国近代史<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、鸦片战争：1840年鸦片战争；1841年英军占领香港；1842年签订《南京条约》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、太平天国：1851年洪秀全发动金田起义；1853年攻占南京\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、洋务运动\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、台湾建省：1885年10月，刘铭传任第一任巡抚；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、甲午中日战争：1895年\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、马关条约：1895.3\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、戊戌变法：1898.6\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、义和团运动\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、八国联军侵华战争：英，俄、日、法、德、美、意、奥\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、辛丑条约：1901.9\r\n<\/p>","sectionId":1110,"sectionName":"第一节  中国历史","sectionType":1,"sectionUrl":"attached/section/1110.html","seq":11100,"testId":1110,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"<strong>一、古代史<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1、埃及是世界上最早的奴隶制国家\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、古巴比伦王国：《汉谟拉比法典》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、波斯帝国大流士改革\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、古印度：种姓制度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、佛教产生：释迦牟尼佛公元前6世纪创立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、古希腊荷马时代，荷马史诗《伊利亚特》、《奥德赛》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、斯巴达：贵族军事专制统治；雅典：奴隶主共和制\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、马其顿帝国\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、罗马奴隶制共和国\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、斯巴达克起义：古代历史上规模最大的一次奴隶起义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t11、基督教的兴起：1世纪\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t12、文艺复兴三杰：但丁《神曲》、比特拉克《歌集》、薄伽丘《十日谈》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t13、绘画三杰：达芬奇、米开朗琪罗、拉斐尔\r\n<\/p>\r\n<p>\r\n\t<strong>二、近代史<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、英国资产阶级革命：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t导火索：1638年苏格兰人民起义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t开始标志：1640年查理一世议会被否后的新议会召开\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t成果：1689年《权利法案》限制王权，确立君主立宪\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、英国工业革命：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1733年凯伊发明飞梭\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1785年卡特莱发明水力织布机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t瓦特改良蒸汽机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1807年（美）富尔敦制造第一艘汽船\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1814年（英）史蒂芬孙发明火车机车\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、美国独立战争与建国：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1775年莱克星顿枪声\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1776.7.4，杰斐逊发布《独立宣言》，美利坚合众国成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、法国资产阶级革命：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1789.7.14，巴黎人民起义，革命开始\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1789.8.26法国议会通过《人权宣言》，革命成功。法国资产阶级革命是这一时期最彻底最成功的革命\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、科学社会主义的诞生：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）1847.6共产主义者同盟成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）1848.4《共产党宣言》发表，标志着马克思主义的诞生\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、1861.3.3俄沙皇废除农奴制\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、林肯领导美国内战颁布《宅地法》和《解放黑人奴隶宣言》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、日本通过明治维新走上资本主义道路\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、1862普鲁士铁相俾斯麦推行改革；1871年德意志帝国成立，德意志统一\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、1861.3意大利王国成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t11、1864.9第一国际成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t12、1871.3.18世界上第一个无产阶级政权\u201c巴黎公社\u201d成立\r\n<\/p>\r\n<p>\r\n\t<strong>三、现代史<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、第一次世界大战\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t同盟国\u201c德奥意\u201d；协约国\u201c英法俄\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1914.6.28奥匈帝国王储被杀，一战爆发\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1918.11.11德国投降，一战结束\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、十月革命\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1917.11.7，列宁领导的无产阶级革命推翻了资产阶级统治，开辟人类历史新纪元\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、巴黎和约与《凡尔赛和约》：1919.1协约国处置战败的同盟国的和约\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、《九国公约》打破日本独霸中国的局面，使中国回到多国共同支配局面\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、共产国际成立：1919.3.2列宁主导下共产国际成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、苏联社会主义制度建立：1922.12，苏共一大召开，成立苏联；1936，苏共八大通过苏联新宪法，标志着苏联社会主义制度的确立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、二战\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t慕尼黑阴谋：1938.9.28，英法与德意首脑在慕尼黑会晤，将苏台德区割让给德国\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1939.9.1，德国突袭波兰，英法对德宣战，二战爆发\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1940.9，德意日缔结同盟条约\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1941.6.22，德国全面进攻苏联；1942夏斯大林格勒保卫战胜利，成二战拐点\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1941.12.7，日本偷袭珍珠港，美英对日宣战，太平洋战争爆发\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1941.8，罗斯福、丘吉尔签署《大西洋宪章》，1942.1中美英苏等26国发表共同宣言，赞同《大西洋宪章》，世界反法西斯统一战线建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1943.9.3意大利投降，法西斯同盟国开始瓦解\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1943.11，中美英《开罗宣言》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1944.6.6，诺曼底登陆成功，史上最大的两栖登陆（从英国登陆法国）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.2，雅尔塔会议确定战后成立联合国\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.4，苏军攻入柏林，希特勒自杀；1945.5.8德国投降，欧洲战场战争结束\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.7，苏美英签署《波茨坦公告》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.8，美国向广岛、长崎投下原子弹，8月8日苏联对日宣战\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.8.15，日本投降，9月2日日本签署投降书，二战结束\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、联合国成立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1943.10，中美英苏首次提出建立联合国\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1945.4.25，联合国大会在旧金山隆重开幕\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6.25，通过《联合国宪章》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、战后世界格局\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t北约：美英加法等\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t华约：苏保匈德等\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、美苏争霸，苏联解体\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1985，戈尔巴乔夫政治改革引起思想混乱\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1990，苏联放弃共产党领导实行多党制\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1991.12，独联体成立，苏联解体\r\n<\/p>","sectionId":1111,"sectionName":"第二节  世界历史","sectionType":1,"sectionUrl":"attached/section/1111.html","seq":11110,"testId":1111,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"<strong>一、中国科技发展成就<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1、古代\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）四大发明：造纸术（蔡伦）、印刷术（毕昇）、指南针、火药\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）天文历法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《尚书》记载日食（人类最早记录）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t商代出现阴阳历；《春秋》记载哈雷彗星\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t石申《甘石星经》绘制人类第一张星象表\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《汉书、五行志》最早的太阳黑子记录\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t张衡发明地动仪；祖冲之圆周率\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t隋唐僧一行第一次对子午线长度进行测量\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t郭守敬绘制恒星2500颗\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）医学成就\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t战国：扁鹊\u201c望闻问切\u201d、\u201c脉学之宗\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t东汉：张仲景\u201c医圣\u201d《伤寒杂病论》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t东汉末：神医华佗发明\u201c麻沸散\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t唐代：孙思邈《千金方》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《唐本草》世上最早由国家编订和颁布的药典\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t明代：李时珍《本草纲目》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t传统四大医学经典：《黄帝内经》、《难经》、《伤寒杂病论》、《神农本草经》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）数学\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中国最早采用十进制\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t殷商时四则运算\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t战国时乘法口诀\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t商代商高发现勾股定律\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《周髀算经》、《九章算术》最著名的数学著作\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t三国刘徽割补法求圆周率\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t南北朝祖冲之圆周率：3.1415926（7）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、新中国科技成就\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1956.7：沈阳飞机厂制出第一驾喷气式飞机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1958.6： 长春一汽造出第一辆红旗轿车\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1959.9在黑龙江发现\u201c大庆油田\u201d\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1960年中国第一枚地对地导弹研制成功\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1964.10.16，中国第一颗原子弹爆炸\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1965年人工合成胰岛素，世界第一\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1966年陈景润证明哥德巴赫猜想\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1967年：第一颗氢弹试爆成功\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1970.4.24第一颗人造卫星进入预定轨道，播放《东方红》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1971.8：第一艘核潜艇下水\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1973年世界\u201c杂交水稻之父\u201d袁隆平培养\u201c籼型杂交水稻\u201d成功\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1980年，我国向太平洋发射火箭试验成功；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1981.9.20实现一箭多星\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1983第一台亿次计算机系统银河计算机研制成功\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1983.10王永民发明五笔字型汉字输入法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1984.12.30，南极长城站建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1989.9.26，南极中山站落成\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1984，大亚湾核电站动工兴建，1994建成\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1988，中国第一座高能加速器电子对撞机对撞成功\u2014\u2014北京正负电子对撞机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1993.10，曙光一号大型计算机研制成功，世界领先\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1994年长江三峡实现大江截流\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1999.6首赴北极科考\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2000.11.29国防科大类人型机器人问世\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2001人类基因组\u201c中国卷\u201d率先绘制完成\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2006年青藏铁路通车\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2009年南极昆仑站建立\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2010.11.14，世界最快的超级计算机\u201c天河一号\u201d\r\n<\/p>\r\n<p>\r\n\t<strong>二、世界科技史<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、天文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1543波兰哥白尼《天体运行论》、日心说\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1705年英国哈雷发表《彗星天文学论说》，发现哈雷彗星\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、物理\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1509意大利伽利略做自由落体三定律实验\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1666英国牛顿发现万有引力定律\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1752美国富兰克林发明避雷针\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1765英国哈格里沃斯发明珍妮纺纱机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1765---1787英国瓦特改良蒸汽机\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1822法国安培发明安培定律\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1826德国欧姆发现欧姆定律\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1831年英国法拉第发现电磁感应\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1840年英国焦耳发现焦耳定律\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、生物\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1628英国哈维发现血液循环\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1859年英国达尔文发表《物种起源》生物进化论\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、数学\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1637年法国笛卡尔创立解析几何1665---1676牛顿和莱布尼茨创立微积分\r\n<\/p>","sectionId":1112,"sectionName":"第三节  中外科技发展史","sectionType":1,"sectionUrl":"attached/section/1112.html","seq":11120,"testId":1112,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"<p>\r\n\t<strong>一、古代文学<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、《诗经》：第一部诗歌总集；风、雅、颂\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、先秦散文：《尚书》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（最早的一部历史文献汇编）、《春秋》（第一部编年体断代史）；《左传》（第一部记事详备的编年体史书）、《国语》（最早的一部国别体史书）；《战国策》（国别体史书，记载战国时期）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、诸子散文：《论语》、《孟子》、《墨子》、《庄子》、《荀子》、《韩非子》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、屈原：《楚辞》--代表文章《离骚》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、吕不韦《吕氏春秋》和李斯《谏逐客书》；司马迁《史记》和班固《汉书》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、建安诗歌：曹操、曹植、曹丕，曹植七步诗\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、唐诗：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t初唐四杰\u2014\u2014王勃、杨炯、卢照邻、骆宾王\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t盛唐：田园诗派：王维、孟浩然\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t边塞诗派：岑参、高适\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t浪漫主义诗人：李白（诗仙）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t现实主义诗人：杜甫（诗圣）三吏三别(《新安吏》《石壕吏》《潼关吏》，《新婚别》《垂老别》《无家别》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t新乐府运动：白居易（诗魔、诗王）《长恨歌》、《琵琶行》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t晚唐：李贺、刘禹锡（诗豪）、杜牧、李商隐\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t李杜：李白、杜甫\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t小李杜：李商隐、杜牧\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、宋文学：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t宋词\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（北宋）苏轼、李煜；李清照、辛弃疾\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（南宋）陆游（我国现存诗最多的诗人9300多首）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t唐宋八大家：（唐）韩愈、柳宗元；（宋）欧阳修、苏轼、苏洵、苏辙、王安石、曾巩\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、元代：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t元曲（杂剧、散曲、戏剧）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t元杂四大家：关汉卿、郑光祖、白朴、马致远\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t散曲：马致远成就最高\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t戏剧：关汉卿、王实甫、马致远\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、明清小说：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t明朝四大奇书：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t罗贯中的《三国演义》、施耐庵的《水浒传》、吴承恩的《西游记》、兰陵笑笑生的《金瓶梅》；(《劝世良言》\u2014\u2014洪秀全，发动太平天国)\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t白话小说的兴起：冯梦龙的\u201c三言\u201d《喻世明言》、《警世通言》、《醒世恒言》；凌濛初的\u201c二拍\u201d《初刻拍案惊奇》和《二刻拍案惊奇》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t清代文学：《红楼梦》、《儒林外史》为代表\r\n<\/p>\r\n<p>\r\n\t<strong>二、现代文学<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、1915.9：陈独秀创办《青年杂志》后改名《新青年》，新文化运动开始；胡适《文学改革刍议》；鲁迅《狂人日记》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、文学研究会：周作人（鲁迅的二弟）、郑振铎、茅盾（沈雁冰）、叶圣陶（叶绍钧）等人发起；主要作家：叶圣陶、朱自清、冰心（谢婉莹）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、茅盾：长篇小说《子夜》《蚀》，蚀三部曲：《幻灭》《动摇》、《追求》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t农村三部曲：《春蚕》、《秋收》、《残冬》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、创造社：1921.6留日文人组成，发起人：郭沫若、郁达夫\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、新月社：1923年成立：发起人：胡适、徐志摩、闻一多、梁实秋\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、语丝社：1924年成立，发起人：林语堂、俞平伯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、南国社：1927年成立，发起人：田汉、欧阳予倩、徐志摩、徐悲鸿、周信芳等\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8、中国现代文学三部曲\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t★巴金的三套三部曲：激流三部曲：《家》《春》《秋》，爱情三部曲：《雾》《雨》《电》，抗战三部曲：《火》一二三部\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t★郭沫若的两套三部曲女神三部曲：《女神之再生》《湘累》《棠棣之花》漂流三部曲：《歧路》《炼狱》《十字架》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t★茅盾的两套三部曲：蚀三部曲：《幻灭》《动摇》《追求》农村三部曲：《春蚕》《秋收》《残冬》★李乔寒夜三部曲：《寒夜》《荒村》《孤灯》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t★金庸射雕三部曲：《射雕英雄传》《神雕侠侣》《倚天屠龙记》★梁羽生唐代三部曲：《大唐游侠传》《龙凤宝钗缘》《慧剑心魔》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9、左翼作家联盟（左联）：1930.3.2成立，鲁迅、田汉、沈瑞先、郑伯奇等任常委\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10、鸳鸯蝴蝶派：在上海\u201c十里洋场\u201d形成的文学流派\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t11、建国以后，小说家:赵树理《三里湾》、周立波《山乡巨变》；诗歌艾青《大堰河》、郭小川《青纱帐》；戏剧老舍《茶馆》、曹禺《雷雨》；散文：巴金、杨朔、李若冰、刘白羽\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t12、文革时期文学作品：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t八个\u201c样板戏\u201d：京剧现代戏《智取威虎山》、《海港》、《红灯记》、《沙家浜》、《奇袭白虎团》、芭蕾舞剧《红色娘子军》、《白毛女》及交响音乐《沙家浜》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t小说：浩然的《金光大道》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t13、新时期文学：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）伤痕文学：刘心武的《班主任》、卢新华的《伤痕》；反思文学：王蒙的《杂色》、张贤亮的《绿化树》、冯骥才的《啊！》、梁晓声《雪城》、张抗抗《隐形伴侣》、老鬼《血色黄昏》、梁晓声《这是一片神奇的土地》《今夜有暴风雪》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）矛盾文学奖\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）朦胧诗派舒婷、顾城、江河、杨炼等\r\n<\/p>","sectionId":1114,"sectionName":"第四节  中国文学","sectionType":1,"sectionUrl":"attached/section/1114.html","seq":11140,"testId":1114,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"<p style=\"text-indent:2em;\">\r\n\t1.柏拉图（古希腊）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.亚里士多德（古希腊）《诗学》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.但丁（意大利）《神曲》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.薄伽丘（意大利）《十日谈》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5.塞万提斯（西班牙）《堂吉诃德》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6.孟德斯鸠（法国）伏尔泰（法国）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7.卢梭（法国）《论人类不平等的起源和基础》《爱弥尔》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t8.歌德（德国）《浮士德》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t9.英国浪漫主义诗人（拜伦、雪莱）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t10.雨果（法国浪漫主义文学领袖）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t11.法国浪漫主义作家（亚历山大·大仲马／小仲马）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t12.普希金（俄国浪漫主义）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t13.巴尔扎克（法国）《人间喜剧》《葛朗台》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t14.狄更斯（英国批判现实主义作家）《双城记》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t15.契诃夫《变色龙》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t16.勃朗特三姐妹（艾米丽《呼啸山庄》）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t17.夏洛《简·爱》、安妮《爱格尼斯·格雷》）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t18.列夫·托尔斯泰《战争与和平》《安娜·卡列尼娜》《复活》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t19.马克·吐温《竞选州长》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t20.高尔基（俄）《童年》《在人间》《我的大学》《母亲》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t21.苏联（马雅可夫斯基《列宁》）\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t22.阿·托尔斯泰《苦难的历程》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t23.法捷耶夫《毁灭》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t24.西奥多·德莱赛（美国现实主义作家）《美国的悲剧》《珍妮姑娘》《嘉莉妹妹》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t25.海明威《太阳照常升起》《永别了、武器》《丧钟为谁而鸣》《老人与海》\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t26.马尔克斯（拉丁美洲）（魔幻现实主义）《百年孤独》\r\n<\/p>","sectionId":1229,"sectionName":"第五节  外国文学史","sectionType":1,"sectionUrl":"attached/section/1229.html","seq":12290,"testId":1229,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"<strong>一、儿童文学的\u201c三大母题\u201d：<\/strong><p style=\"text-indent: 2em;\" >\r\n爱的母题、顽童的母题、自然的母题<p  >\r\n<strong>二、作品：<\/strong><p style=\"text-indent: 2em;\" >\r\n卡罗尔（英、数学家）：《爱丽丝梦游仙境》<p style=\"text-indent: 2em;\" >\r\n达尔（英）：《查理和巧克力工厂》<p style=\"text-indent: 2em;\" >\r\n亚米契斯（意大利）：《爱的教育》<p style=\"text-indent: 2em;\" >\r\n伯勒斯（英）：《人猿泰山》<p style=\"text-indent: 2em;\" >\r\n格拉洛芙（瑞典）：《骑鹅历险记》<p style=\"text-indent: 2em;\" >\r\n格雷厄姆（英）：《柳林风声》<p style=\"text-indent: 2em;\" >\r\n蒙哥马利（加）：《绿山墙的安妮》<p style=\"text-indent: 2em;\" >\r\n托尔金（英国）：《哈比人历险记》<p style=\"text-indent: 2em;\" >\r\n安东尼（法）：《小王子》<p style=\"text-indent: 2em;\" >\r\n科洛迪（意）：《木偶奇遇记》<p style=\"text-indent: 2em;\" >\r\n王尔德（俄）：《快乐王子》<p style=\"text-indent: 2em;\" >\r\n格林兄弟（德）：《白雪公主》<p style=\"text-indent: 2em;\" >\r\n叶圣陶（中）：《稻草人》<p style=\"text-indent: 2em;\" >\r\n迈克尔·恩德（德）：《说不完的故事》<p style=\"text-indent: 2em;\" >\r\n安徒生（丹）：《安徒生童话》<p style=\"text-indent: 2em;\" >\r\n凯瑟琳、罗琳（英）：《哈利、波特》<p style=\"text-indent: 2em;\" >\r\n弗兰克、鲍姆（美国）：《绿野仙踪》\r\n","sectionId":1230,"sectionName":"第六节  儿童文学","sectionType":1,"sectionUrl":"attached/section/1230.html","seq":12300,"testId":1230,"timeLength":0},{"chapterId":403,"free":0,"remark":"","sectionContent":"\r\n<strong>一、艺术鉴赏概述<\/strong><p style=\"text-indent: 2em;\" >\r\n1、命题和范畴<p style=\"text-indent: 2em;\" >\r\n（1）定义：受众凭借艺术作品而展开的一种积极的、主动的审美再创造活动<p style=\"text-indent: 2em;\" >\r\n（2）性质：人们对艺术作品进行的非反思性的审美接受活动<p style=\"text-indent: 2em;\" >\r\n（3）特征：<p style=\"text-indent: 2em;\" >\r\nA、充满感性与理性的统一<p style=\"text-indent: 2em;\" >\r\nB、充满情感和想象<p style=\"text-indent: 2em;\" >\r\nC、充满积极主动的审美再创造<p style=\"text-indent: 2em;\" >\r\nD、充满审美通感和个人审美的偏爱与差异<p>\r\n<strong>二、艺术鉴赏活动展开的基本条件<\/strong><p style=\"text-indent: 2em;\" >\r\n1、艺术品必须具有审美魅力、审美内涵、审美价值的审美对象<p style=\"text-indent: 2em;\" >\r\n2、鉴赏者必须是具有一定艺术素养、文化知识、生活阅历、审美能力的审美主体<p style=\"text-indent: 2em;\" >\r\n3、鉴赏者必须和审美鉴赏对象之间建构起相应的审美关系<p  >\r\n<strong>三、艺术鉴赏的意义<\/strong><p style=\"text-indent: 2em;\" >\r\n1、艺术品须通过鉴赏者的再创造才能发挥社会意义和美学价值<p style=\"text-indent: 2em;\" >\r\n2、受众在鉴赏中的审美再创造是积极主动的<p style=\"text-indent: 2em;\" >\r\n3、艺术鉴赏和艺术创作一样都是自身主体力量在审美活动中的自我肯定与自我实现<p >\r\n<strong>四、艺术鉴赏力的培养与提高<\/strong><p style=\"text-indent: 2em;\" >\r\n1、优秀作品鉴赏实践<p style=\"text-indent: 2em;\" >\r\n2、掌握艺术基本知识和规律<p style=\"text-indent: 2em;\" >\r\n3、学习一定的历史、文化知识<p style=\"text-indent: 2em;\" >\r\n4、积累生活经历与生活阅历<p style=\"text-indent: 2em;\" >\r\n5、接受美育和艺术教育<p >\r\n<strong>五、艺术鉴赏中的心理现象<\/strong><p style=\"text-indent: 2em;\" >\r\n1、鉴赏中的多样性与一样性<p style=\"text-indent: 2em;\" >\r\n2、鉴赏中的保守性与变异性<p >\r\n<strong>六、艺术鉴赏的审美心理<\/strong><p style=\"text-indent: 2em;\" >\r\n1、注意2、感知3、联想4、想象5、情感6、理解<p >\r\n<strong>七、艺术鉴赏的审美过程<\/strong><p style=\"text-indent: 2em;\" >\r\n1、艺术鉴赏中的审美直觉<p style=\"text-indent: 2em;\" >\r\n2、艺术鉴赏中的审美体验<p style=\"text-indent: 2em;\" >\r\n3、艺术鉴赏中的审美升华<p >\r\n<strong>八、艺术鉴赏的一般规律在教育教学活动中应用<\/strong><p style=\"text-indent: 2em;\" >\r\n1、充分揣摩作品内涵<p style=\"text-indent: 2em;\" >\r\n2、引导受教育者主动参与<p style=\"text-indent: 2em;\" >\r\n3、为受教育者提供理性指导<p style=\"text-indent: 2em;\" >\r\n4、自主探究、实现教育功能\r\n","sectionId":1231,"sectionName":"第七节  艺术鉴赏","sectionType":1,"sectionUrl":"attached/section/1231.html","seq":12310,"testId":1231,"timeLength":0}],"seq":4290},{"chapterId":404,"chapterName":"第七章 考点归纳：教师基本能力","courseId":51,"description":"第七章 考点归纳：教师基本能力","sectionList":[{"chapterId":404,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1.具有运用工具书检索信息、资料的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2.具有运用网络检索、交流信息的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3.具有对信息进行筛选、分类、管理和应用的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4.具有运用教育测量知识进行数据分析与处理的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5.具有根据教育教学的需要，设计、制作课件的能力。\r\n<\/p>\r\n<p>\r\n\t<strong>一、工具书的检索与利用<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、工具书种类：字典、辞典、书目、索引、年鉴、手册、年表、图谱、政书类书和百科全书\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、工具书检索的一般程序\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）确定检索范围（2）选择合适工具书（3）检索（4）摘录与复制（5）整理资料\r\n<\/p>\r\n<p>\r\n\t<strong> 二、网络信息检索与利用<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、图书检索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、中国期刊网\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、网页搜索\r\n<\/p>\r\n<p>\r\n\t<strong>三、信息处理<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、信息的筛选与分类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）筛选：鉴别真伪、价值鉴定；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）分析：归纳与演绎、比较与分类、分析与综合、定量与定性、系统分析\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）提炼\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）综合\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、信息传递：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）口头传递（2）书面传递（3）电信传递\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、信息存储，要求：信息要有价值、要方便利用、要现代化\r\n<\/p>\r\n<p>\r\n\t<strong>四、运用教育测量知识进行数据分析与处理<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、测验种类：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）常模参照测验：参照被试群体的实际水平解释分数的测验\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）目标参照测验：参照被测达到目标的程度来解释的测验\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、测量的要素（1）参照点（2）统一的单位（3）测量工具\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、数据处理\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t难度：试卷的难易程度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t区分度：试卷对不同考生的知识、能力水平的鉴别程度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t信度：衡量测验分数一致性或可靠性的指标\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t效度：测验有效性或准确性的指标\r\n<\/p>","sectionId":1115,"sectionName":"第一节  信息处理能力","sectionType":1,"sectionUrl":"attached/section/1115.html","seq":11150,"testId":1115,"timeLength":0},{"chapterId":404,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong>\r\n<p style=\"text-indent:2em;\">\r\n\t1、了解一定的逻辑知识，熟悉分析、综合、概括的一般方法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、掌握比较、演绎、归纳的基本方法，准确判断、分析各种事物之间的关系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、准确而有条理地进行推理、论证。\r\n<\/p>\r\n<p>\r\n\t<strong>一、逻辑基础知识<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、概念：反应事物属性和范围的思维形式\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、内涵：反应事物的特性和本质\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、外延：概念的适用范围；结论：概念的内涵越多，外延越少；概念的内涵越少，则外延越多\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t概念外延之间的关系：全同、全异、真包含、真包含于、交叉关系\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、命题：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）命题是对思维对象有所断定的思维形式\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）性质：必须对事物的情况有所断定；必须有真和假的区分\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）分类：模态命题；非模态命题\r\n<\/p>\r\n<p>\r\n\t<strong>二、推理<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、推理：由一个或几个已知命题推出新命题的思维形式\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、分类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）演绎推理：大前提--小前提--结论\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）归纳推理\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tA、完全归纳推理、\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\tB、不完全归纳推理（简单枚举归纳推理、科学归纳推理（求同法、求异法、并用法、共变法、剩余法））\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）类比推理\r\n<\/p>\r\n<p>\r\n\t<strong>三、论证<\/strong>\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、论证的有效性\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）概念的有效性&nbsp;（2）论据的有效性&nbsp;（3）论证方法的有效性&nbsp;（4）结论的有效性\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<br />\r\n<\/p>","sectionId":1116,"sectionName":"第二节  逻辑思维能力","sectionType":1,"sectionUrl":"attached/section/1116.html","seq":11160,"testId":1116,"timeLength":0},{"chapterId":404,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t1、理解阅读材料中重要概念的含义。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、理解阅读材料中重要句子的含义。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、筛选并整合图表、文字、视频等阅读材料的主要信息及重要细节。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4、分析文章结构，把握文章思路。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t5、归纳内容要点，概括中心意思。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t6、分析概括作者在文中的观点态度。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t7、根据上下文合理推断阅读材料中的隐含信息。\r\n<\/p>\r\n<p>\r\n\t<strong>一、技巧<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）语境分析法：A、联系上下文B、联想文段背景C、把握标点提示\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）修辞提示法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）划分层次法\r\n<\/p>\r\n<p>\r\n\t<strong>二、整合信息技巧分析<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（1）打枝削叶、巧提主干\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（2）删繁就简、去伪存真\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（3）合并同类，列举异义\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t（4）敲骨吸髓，挖掘信息\r\n<\/p>","sectionId":1118,"sectionName":"第三节  阅读理解能力","sectionType":1,"sectionUrl":"attached/section/1118.html","seq":11180,"testId":1118,"timeLength":0},{"chapterId":404,"free":0,"remark":"","sectionContent":"<strong>考点归纳<\/strong> \r\n<p style=\"text-indent:2em;\">\r\n\t掌握文体知识，能根据需要按照选定的文体写作。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t能够根据文章中心组织、剪裁材料。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t具有布局谋篇，安排文章结构的能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t语言表达准确、鲜明、生动，能够运用多种修辞手法增强表达效果。\r\n<\/p>\r\n<p>\r\n\t<strong>一、写作的基础知识<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．写作的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t写作是指人类运用语言文字符号反映客观事物、表达思想感情、传递知识信息的创造性脑力劳动的过程。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．写作的过程分段\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t从现代信息论、系统论的角度来看，写作是一个收集、加工、输出信息的整体系统。作为一个完整的系统过程，写作活动是有阶段性的。大致可分为采集\u2014\u2014构思\u2014\u2014表述三个阶段。具体又可分为采集、立意、谋篇、用语、修改等五个环节。每个阶段和环节都有自身的特点、规律和要求。\r\n<\/p>\r\n<p>\r\n\t<strong> 二、写作手法<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．写作手法的介绍\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t写作手法就是文章中用来表现主题、刻画人物，增强表现力，吸引读者注意力的手段。常见的有：夸张、对比、比喻、拟人；悬念，照应，联想，想象；抑扬结合、点面结合、动静结合、叙议结合、情景交融、衬托对比、伏笔照应、托物言志、白描细描、铺垫悬念、正侧面结合、比喻象征、借古讽今、卒章显志、承上启下、开门见山；烘托、渲染、动静相衬、虚实相生、实写与虚写、托物寓意、咏物抒情、借景抒情等。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．常用写作手法介绍\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)叙事角度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①第一人称叙事法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t文章的内容通过\u201c我\u201d传达给读者，文章中所写的都是叙述人的亲眼所见，亲耳所闻，或者就是叙述者本人的亲身经历。第一人称的作用：是事件的见证者，是文章的线索人物，推动故事情节的发展，体现出文章的真实感和亲切感。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②第二人称叙事法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t常用于书信，一般记叙文中很少通篇采用，但在叙述过程中，为了直接表达情感，在文章的某个局部，转变为第二人称，可以增强文章情感，引起读者的共鸣。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③第三人称叙事法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t用第三人称叙事使叙述人既不受空间、时间的限制，也不受生理、心理的限制，可以直接把文章中的人和事展现在读者面前，能自由灵活地反映社会生活。但第三人称叙事不如第一人称叙事亲切自然。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)叙事顺序\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①顺叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t顺叙是按时间的先后顺序来叙述事件，与事件发生发展的实际情况一致，文章条理清楚，脉络分明。运用顺叙时，应注意剪裁得当，重点突出，防止出现罗列现象和平铺直叙。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②倒叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t主要指除了将个别部分提前，其他仍以顺叙记录，而不是把整个事件都倒过来叙述。倒叙时要交代清楚起点。倒叙与顺叙的转换处，要有明显的界限，还要有必要的文字过渡，做到自然衔接。采用倒叙的情况一般是为了表现文章中心思想，把最能表现中心思想的部分提到前面，加以突出；同时为了使文章结构富于变化，避免平铺直叙；另外则是为了表现效果的需要，使文章曲折有致，造成悬念，引人人胜。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③插叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t有时是为了帮助读者了解故事情节而追叙；有时是对出场人物的情节作注释、说明。使用插叙一定要服从表达中心思想的需要，做到不节外生枝，不喧宾夺主。在插入叙述的时候，还要注意文章的过渡、照应和衔接，不能有断裂的痕迹。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④补叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t补叙主要用于对上文的叙述加以补充说明，一般是片断性的、简要的，不具备完整的事件，也可以把解释或说明的文字放在前面，以引起下文。补叙一般不发展情节、事件，只对原来的叙述起丰富、补充作用。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤分叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t分叙可以先叙一件，再叙另一件，也可以几件事情交叉叙述。采用分叙时要根据文章内容和表达中心思想的需要确立叙述的线索，还要交代清楚每一事件发生和发展的时间。分叙的作用是把头绪纷繁、错综复杂的事情，写得眉目清楚，有条不紊。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(3)叙事线索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①以物为线索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t叙事过程中让某物在事件发展各阶段反复出现，并通过各种手段有意强化其形象，使物件起到过渡或象征和点明中心思想的作用。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②以人为线索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以某人为叙事线索，将其统一形象贯穿全文，令某人成为全文重要关注点，或塑造人物，或推动情节。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③以思想变化为线索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t这种写法，思想发展的主线要分明。将思想变化的各个阶段作为线索贯穿全文，形成连接照应。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④以中心事件为线索\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t主要事件记叙突出，次要事件交代清楚，主次搭配合理，突出主旨，可使复杂事件繁而不乱。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(4)情感抒发\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①直接抒情法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t一般适用于抒发强烈而紧张的感情，可以使感情表达得朴实真切，震动人心。特点是叙述时感情强烈，节奏快、紧张，情感直露，容易把握。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②间接抒情法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t间接抒情一般可以在客观叙述的同时，加入作者主观的感情色彩，使读者在叙述过程中感受作者的思想感情；也可通过议论表达作者强烈的爱憎、褒贬，或者在描写中渗透自己的情感，使文章语言富有感情色彩。间接抒情的特点是抒情含蓄婉转，富有韵味。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(5)议论文体\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①先叙后议法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t即先叙事后议论，达到叙事和议论的统一。议论的方法，可以通过文章的人物语言、心理活动进行议论，也可以以第三者的身份进行议论。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②先议后叙法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t即先议后叙，首先通过议论，开门见山地提出记叙的要点和中心，以此统领全文，使全文所记事件的意义显得清楚明白。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③夹叙夹议法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t将叙事和议论穿插进行，写法上灵活多变，作者自由自在地表情达意。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(6)描写方法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①写生法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t写生法是美术术语，这里用来指描写器物注意按照一定顺序，或由上到下，或由下到上，或从左到右，或从右到左，或先中间后两边，或先两边后中间，或先整体后部分，或先部分后整体，同时注意刻画细节，给读者留下深刻印象。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②转动法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t从不同角度动态地对器物进行描述，准确运用正面、反面、上面、下面、左面、右面等方位词，对器物进行全方位介绍。中间要有详有略，切忌面面俱到、平均用力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③剥笋法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t对于一些结构比较复杂的器物，可以采取从外到里或从里到外的顺序把其结构描述出来，由里及外，突出中心和重点。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④拟人法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t找到人与一些无生命器物或动植物的某些特点的相似之处，进行细致的描绘。把动物比拟成人，首先要从整体上把它比拟成人，然后再找出与人的局部相似之处。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤化动法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t把器物描述从描写静态转入想象动态或从动态转入想象静态，动态与静态描写结合，使二者相映成趣。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑥说明法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t对器物进行描写时，有时要说明它的特点或作用，也可说明物品的历史、特点或用途，增加读者对器物的了解。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑦\u201c五官\u201d法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t运用人的五官感知能力，把各种不同感觉、感受写出来，使人对一定情感和器物的描写更具体、直接。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑧借物抒情法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在描写物品时将感情寄托于对事物的爱憎之中，借器物的形象含蓄地抒发自己的感情，使物与情相统一，使情有所依托。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑨托物言志法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t用某一物品来比拟或象征某种精神、品格、思想、感情等，使器物与志向，器物与感情发生内在联系。常用比喻、拟人、象征等手法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑩物品自述法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t实则是拟人手法的通篇使用，准确地把握物品的特征．采用第一人称描述物品，使器物显得形象生动，吸引读者的兴趣，同时鲜明地表现出作者的思想感情。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t\u201c三江并流\u201d法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在主体部分中，用三个反问段落作为文章的主题部分，围绕主题并列展开。文章段落属于横向联系，运用并列关系将要写的东西分别呈现，使读者对文章主体一目了然。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(7)建筑描写法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①远眺近看法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t对建筑物可以远看，也可以近视。远眺可得到建筑物整体印象和整体轮廓。描写建筑物时，最好把远眺和近看的结果结合起来写，使读者对建筑物的整体和各部分情况有详细的了解，从而获得完整印象。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②内外结合法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t从外面看建筑物的轮廓，从内部看建筑物的构造和功能，重点是内部组成和功能，一般要按方位顺序依次进行介绍，这样才能条理清楚。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③换步观形法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t不断变换立足点和观察点，对建筑物进行多方面的观察描写，得到不同侧面的完整印象。采用移步换形法描写建筑物一定要把观察点和立足点交代清楚，还要抓住建筑物最主要的特征来写。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④说明介绍法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t对建筑的特点、历史等可采用说明介绍法，紧扣文章中心简明扼要地说明介绍。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤环境衬托法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t通过对建筑物周围的景致进行适当描写，可使建筑物更加突出。在描写周围的景色时，要把观察点和立足点介绍清楚，便于读者了解建筑物整体位置。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(8)动植物描写法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①对动物进行描写时，可对动物外形各组成部分的形状和颜色特点，采用总分结合法描述。要注意总述与分述之间的关系。分述部分要紧紧围绕总述所讲的特点描写。各分述部分要有一定的顺序和条理。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②在描写植物的时候，可以对各个部分进行描述，也可以只对某一部分进行描述。描写时要重点突出，可以从最能体现这棵植物特点的部分的颜色、形状、气味等入手具体描写。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(9)景点描写法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t对景区特征描写，既要逼真地再现具体的时令特征，又要表现景物本身的特征，使时令特征和景物特征融为一体。要注意观察景区不同时段的变化特征，体现景物所发生的任何细微变化。可采用定点或换点取景法，选择较能反应景区特点、特色的地点，按照一定顺序，由近及远或由远及近、由高到低或由低到高、从左到右或从右至左等，把景物写得层次清楚、鲜明逼真、有立体感，给读者以如临其境之感。\r\n<\/p>\r\n<p>\r\n\t<strong>三、新闻文体类<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t新闻文体是指报纸、电台、电视台经常使用的记录社会、传播信息、反映时代的一种文体，其种类很多，这里只介绍经常使用的消息、通讯和新闻特写。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．消息\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)消息的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t消息是用概括的叙述方式、简明扼要的文字，迅速及时地报道新近发生的、有价值的、群众最关心的事实。一般有狭义和广义之分。狭义的单指消息；广义的指消息、通讯、报告文学、特写、评论等等。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)消息的分类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t一般把消息概括为四类：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①动态消息\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t迅速而准确地报道新近发生的国际、国内重大事件、重要的活动，以及各项建设中的新情况、新动态、新成就、新问题的一种文体，是报纸上使用最多的一类文体。重大新闻的简讯都属于动态消息。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②典型消息\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t也叫经验消息，它是对一些具体部门、单位、行业的典型经验、成功做法集中报道的一种文体。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③综合消息\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t综合消息是把发生在不同地点、不同单位、各具特色、性质相同的事实综合在一起，并体现一个主题的报道。它的特点是在综合、概括事实的基础上，进行分析，提出见解，揭示规律。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④述评消息\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t又称\u201c记者述评\u201d\u201c新闻述评\u201d，是一种兼有消息与评论作用的新闻。它是在陈述事实的基础上，穿插评论或抒发感慨，从而分析说明所报道事实的本质和意义。它的特点是边叙边评，要求以国家的方针政策为依据，针对事实进行评说，要求观点正确，评论得当。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．通讯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)通讯的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t通讯，是运用叙述、描写、抒情、议论等多种手法，具体、生动、形象地反映新闻事件或典型人物的一种新闻报道形式。它是记叙文的一种，是报纸、广播电台、通讯社常用的文体。它是一种比消息更详细地报道具有新闻意义的事件、经验或典型人物的一种文体。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)通讯的写作步骤\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t通讯的写作步骤一般分为如下几步：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t首先是立意，确立主题。立意就是确定思想．提炼主题，立意的过程也就是找角度的过程。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t其次是确定结构。可以运用按时间顺序来写的纵式结构，按逻辑顺序来写的横式结构，也可运用纵横结合的写法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第三是选取材料。要选择最能再现人物或者一件事件本质的材料。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第四是明确语言表达方式和表现手法。通讯的语言要具体，不要抽象，尽量少用形容词和数字，可以多用动词和群众语言。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t最后是着笔写作，要注重创新写法。多作细节与环境的描写，把人物放到环境中去。写作时可以先分好几个小层次，做好小题目，分块去写。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(3)常见的通讯类型\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t通讯按内容分，一般分为人物通讯、事件通讯、概貌通讯和工作通讯。通讯按形式分，分为纪实通讯、新闻特写、新闻专访、新闻调查、专题侧记、随行散记、记者手记、新闻花絮等。这里重点介绍以下几类：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①人物通讯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t所谓人物通讯，就是以报道各条战线上的先进人物为主的通讯。它着重揭示先进人物的精神境界，通过写人物的先进事迹，反映出人物的先进思想，使之成为社会的共同财富。同时，也报道转变中的人物和某些有争议的人物。\u201c金无足赤，人无完人\u201d，在写作时切记不可把先进人物写成从来没有过的大智大勇，十全十美。写人叙事力求言真意切，恰如其分。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②事件通讯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t所谓事件通讯，就是报道典型的、有普遍教育意义的新闻事件。写事当然离不开写和事件有关的人，但它不像人物通讯那样着力刻画人，而是以事件为中心，在事件的总画面中，为了写好事而来写人。它既可以反映现实生活中发生的重大的、振奋人心的典型事件；也可以从某一新闻事件中截取一个或若干个片断，进行细致详尽的描述，揭示事件的深刻含义；还可以是若干事件的综述。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③工作通讯\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t所谓工作通讯，就是反映贯彻执行党的路线、方针、政策中的成绩，总结实际工作中的经验和教训，或者探讨有争议的亟待解决的问题的报道。它是报纸上经常运用指导工作的重要报道形式。它的主要特点有四条：一是把介绍工作经验和分析问题作为主旨；二是凭借事实，深入分析；三是生动活泼，讲究文采；四是不拘一格，形式多样。随笔、散记、侧记、札记、记事均可。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3．新闻特写\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)新闻特写的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t新闻特写，用类似电影\u201c特写镜头\u201d的手法来反映事实，是作者深入事件新闻现场采写的一种现场感较强、篇幅较短小的新闻文体，侧重\u201c再现\u201d。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t截取新闻事实的横断面，抓住富有典型意义的某个空间和时间，通过一个片断、一个场面、一个镜头、对事件或人物、景物做出形象化的报道的一种有现场感的生动活泼的新闻体裁。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)新闻特写的种类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t新闻特写通常有以下几种：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t① 事件特写：摄取与再现重大事件的关键性场面。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t② 场面特写：新闻事件中精彩场面的再现。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③ 人物特写：再现人物的某种行为，绘声、绘色，有强烈动感。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④景物特写：对于有特殊意义或有价值的罕见景物的描写。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤工作特写：对于某一工作场面的生动再现。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑥杂记性特写：各种具有特写价值的新闻现场的生动再现。\r\n<\/p>\r\n<p>\r\n\t<strong> 四、文学文体类<\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．散文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)散文的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t散文有广义和狭义两种概念。广义的散文，在古代指的是一切不押韵的文章。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)散文种类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t根据散文的内容和性质可将散文分为以下几类：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①叙事散文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以写人记事为主的散文。这类散文对人和事的叙述和描绘较为具体、突出，同时表现作者的认识和感受，也带有浓厚的抒情成分，字里行间充满饱满的感情。叙事散文侧重于从叙述人物和事件的发展变化过程中反映事物的本质，具有时间、地点、人物、事件等因素。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②抒情散文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以抒发作者主观感情为主的散文称为抒情散文。抒情散文往往借助具象，写景状物来抒发主观情感。文中的景或物是作者抒情的依托，作者往往将所要抒发的情感具象化，运用比兴、象征、拟人等手法，或写景抒情，情景交融，或托物咏志，有所寄托，以达到抒情的目的。大致可分为借景抒情、因物抒情和以事抒情三类。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t③写景散文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以描绘景物为主的散文。这类文章多是在描绘景物的同时抒发感情，或借景抒情，或寓情于景，抓住景物的特征，按照空间的变换顺序，运用移步换景的方法，把观察的变化作为全文的脉络。生动的景物描绘，不仅可以交代背景，渲染气氛，而且可以烘托人物的思想感情，更好的表现主题。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④哲理散文\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t以散文的形式讲哲理、启迪人生的文章称为哲理散文。哲理散文以种种形象来参悟生命的真理，从而揭露万物之间的永恒相似，因其深邃性和心灵透辟的整合，给人们一种透过现象深入本质，揭示事物的底蕴、观念，具有震撼性的审美效果。把握哲理散文体现出的思维方式，运用象征思维、联想思维和情感思维，去体悟哲理散文所蕴藏的深厚的文化底蕴和文化积淀。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．诗歌\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t诗歌是文学体裁的一种，形式较为多样化，是世界上最古老、最基本的文学形式。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)诗歌的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t诗歌是高度集中地概括反映社会生活的一种文学体裁，它饱含着作者的思想感情与丰富的想象，语言凝练而形象性强，具有鲜明的节奏，和谐的音韵，富于音乐美，语句一般分行排列，注重结构形式的美。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)诗歌的主要表现手法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①赋比兴手法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t诗歌的表现手法很多，我国最早流行而至今仍常使用的传统表现手法有：赋、比、兴。《毛诗序》说：\u201c故诗有六义焉：一曰风，二曰赋，三曰比，四曰兴，五日雅，六曰颂。\u201d\u201c六义\u201d中，\u201c风、雅、颂\u201d是指《诗经》中诗篇的内容，\u201c赋、比、兴\u201d就是诗中运用的表现手法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t赋：是直接陈述事物的表现手法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t比：是用比喻的方法描绘事物，表达思想感情。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t兴：是托物起兴，即借某一事物开头来引起正题要描述的事物和表现思想感情的写法。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t这三种表现手法一直流传下来，常常综合运用、互相补充，对历代诗歌创作都有很大的影响。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②想象手法\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t诗歌的表现手法很多，但丰富的想象既是诗歌的一大特点，也是诗歌最重要的一种表现手法。具体包括：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t象征。简单说就是\u201c以象征义\u201d．在现代诗歌中．象征则义表现为心灵的商接意象。比拟。比拟或喻于声．或方于貌，或拟于心，或譬于事。实质还是\u201c拟人\u201d。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t夸张。就是把所要描绘的事物放大，以引起读者的重视和联想。夸张不能过于荒诞，或太实太俗。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t借代。就是借此事物代替彼事物。它与比拟有相似之处，但又有所不同，不同之处在于：比拟一般是比的和被比的事物都是具体的、可见的；而借代却是一方具体．一方较为抽象，把具体与抽象联系起来，使诗歌的形象更为鲜明、突出。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3．小说\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(1)小说的概念\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t小说是作者通过叙述人的语言来描绘生活事件，塑造人物形象．展开作品主题，表达作者思想感情，从而艺术地反映和表现社会生活的一种文学体裁。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t(2)小说的分类\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t①按篇幅长短分为长篇小说、中篇小说、短篇小说和微型小说。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t长篇小说。篇幅在十万字以上，具有比较复杂的结构，一般通过比较多的人物和纷繁的事件来表现社会生活，如《红楼梦》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中篇小说。篇幅在三万字至十万字之间，反映生活的范围虽不像长篇那样广阔，但也能反映出一定广度的生活面，如《人到中年》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t短篇小说。篇幅在几千到两万多字，虽然篇幅较小．但结构相对紧凑完整、短小精悍，有些还具有深刻、丰富的社会意义，如刘心武的《班主任》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t微型小说。一般认为微型小说的篇幅应在两千字以下，题材常是生活经验的片段，能见微知著，字句精练。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t②按作品类型分为武侠小说、推理小说、悬疑小说、历史小说、军事小说、言情小说、科幻小说、网游小说等；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④ 按艺术表现分为文艺小说、类型小说(如武侠小说、推理小说、悬疑小说等)；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t④按写作语言分为纯文学小说、通俗小说；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑤按作品内容分为现实小说、超现实小说(如魔幻小说、灵异小说等)；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑥按写作风格分为传统小说、网络小说(包括网游小说、黑道小说、家宅小说等)；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑦按文字语言分为古白话小说、当代古白话小说、文言小说、白话小说、地方语言小说；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑧按作品载体分为平面小说和电子小说；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑨按写作人称分为第一人称小说、第三人称小说、书信体小说、对话体小说、记体小说；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t⑩按主义流派分为古典主义小说、讽刺主义小说、现实主义小说、现代主义小说、批判现实主义小说、浪漫主义小说、自然主义小说、形式主义小说、表现主义小说、存在主义小说、意识流小说、魔幻现实主义小说等；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t11.按年代分为古典小说、现代小说、当代小说：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t12.按进程分为连载小说和全本小说。\r\n<\/p>","sectionId":1120,"sectionName":"第四节  写作能力","sectionType":1,"sectionUrl":"attached/section/1120.html","seq":11200,"testId":1120,"timeLength":0}],"seq":4300},{"chapterId":182,"chapterName":"第八章 历年真题解析","courseId":51,"description":"第八章 历年真题解析","sectionList":[{"chapterId":182,"free":1,"remark":"","sectionContent":"第一节 2016上半年真题及答案","sectionId":1986,"sectionName":"第一节 2016上半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=1986","seq":19860,"testId":1986,"timeLength":0},{"chapterId":182,"free":0,"remark":"","sectionContent":"第二节 &nbsp; 2015下半年真题及答案","sectionId":839,"sectionName":"第二节  2015下半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=839","seq":19870,"testId":839,"timeLength":0},{"chapterId":182,"free":0,"remark":"","sectionContent":"<p class=\"p0\">\r\n\t<span style=\"font-family:'宋体';font-size:16px;\">第三节 2015上半年真题及答案<\/span> \r\n<\/p>","sectionId":462,"sectionName":"第三节 2015上半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=462","seq":19880,"testId":462,"timeLength":0},{"chapterId":182,"free":1,"remark":"","sectionContent":"<p class=\"p0\">\r\n\t<span style=\"font-family:'宋体';font-size:16px;\">第四节 2014下半年真题及答案<\/span> \r\n<\/p>\r\n<span style=\"font-family:'宋体';font-size:12pt;\"><\/span>","sectionId":466,"sectionName":"第四节 2014下半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=466","seq":19890,"testId":466,"timeLength":0},{"chapterId":182,"free":1,"remark":"","sectionContent":"<p class=\"p0\">\r\n\t<span style=\"font-family:'宋体';font-size:16px;\">第五节 2014上半年真题及答案<\/span> \r\n<\/p>","sectionId":465,"sectionName":"第五节 2014上半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=465","seq":19900,"testId":465,"timeLength":0},{"chapterId":182,"free":1,"remark":"","sectionContent":"<p class=\"p0\">\r\n\t<span style=\"font-family:'宋体';font-size:16px;\">第六节 2013下半年真题及答案<\/span> \r\n<\/p>","sectionId":468,"sectionName":"第六节 2013下半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=468","seq":19910,"testId":468,"timeLength":0},{"chapterId":182,"free":1,"remark":"","sectionContent":"<p class=\"p0\">\r\n\t<span style=\"font-family:'宋体';font-size:16px;\">第七节 2013上半年真题及答案<\/span> \r\n<\/p>","sectionId":467,"sectionName":"第七节 2013上半年真题及答案","sectionType":2,"sectionUrl":"examAction!produceExam.action?sectionId=467","seq":19920,"testId":467,"timeLength":0}],"seq":4360}]
     * course : {"chargeType":0,"courseCount":0,"courseId":51,"courseName":"2016中学《综合素质》复习资料","effective":1,"evalLevel":0,"examSubject":"中学.综合素质","introduce":"        精心整理的全套考前复习资料，包括：改革后教师资格证考试介绍，对考试方式和考试科目有详细的讲解；考试大纲的详细解析，考试目标、内容、要求及试卷结构与题型事例；所有考点的归纳总结，书本当中的常考点和历年考点进行整理；全套历年考试试卷及详细的答案解析。\r\n        伴我考深知考生学习的痛苦，复习资料做的短小精悍，但这背后是聘请名师花更多时间和成本，参考大量资料并提炼和精简，浓缩后的都是精华，减轻考生学习负担，有基础的考生能成倍提升通过率。","oneWord":"大纲详解、考点归纳和历年真题解析","pictureUrl":"attached/books/20151120144153.png","projectId":1,"readCount":0,"replayDate":1443628800000,"replayUsername":"潘捷","seq":4300,"useRange":0}
     */

    private CourseBean course;
    private List<EvalBean> chapterList;

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public List<EvalBean> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<EvalBean> chapterList) {
        this.chapterList = chapterList;
    }

    public static class CourseBean {
        /**
         * chargeType : 0
         * courseCount : 0
         * courseId : 51
         * courseName : 2016中学《综合素质》复习资料
         * effective : 1
         * evalLevel : 0
         * examSubject : 中学.综合素质
         * introduce :         精心整理的全套考前复习资料，包括：改革后教师资格证考试介绍，对考试方式和考试科目有详细的讲解；考试大纲的详细解析，考试目标、内容、要求及试卷结构与题型事例；所有考点的归纳总结，书本当中的常考点和历年考点进行整理；全套历年考试试卷及详细的答案解析。
         * 伴我考深知考生学习的痛苦，复习资料做的短小精悍，但这背后是聘请名师花更多时间和成本，参考大量资料并提炼和精简，浓缩后的都是精华，减轻考生学习负担，有基础的考生能成倍提升通过率。
         * oneWord : 大纲详解、考点归纳和历年真题解析
         * pictureUrl : attached/books/20151120144153.png
         * projectId : 1
         * readCount : 0
         * replayDate : 1443628800000
         * replayUsername : 潘捷
         * seq : 4300
         * useRange : 0
         */

        private int chargeType;
        private int courseCount;
        private int courseId;
        private String courseName;
        private int effective;
        private int evalLevel;
        private String examSubject;
        private String introduce;
        private String oneWord;
        private String pictureUrl;
        private int projectId;
        private int readCount;
        private long replayDate;
        private String replayUsername;
        private int seq;
        private int useRange;

        public int getChargeType() {
            return chargeType;
        }

        public void setChargeType(int chargeType) {
            this.chargeType = chargeType;
        }

        public int getCourseCount() {
            return courseCount;
        }

        public void setCourseCount(int courseCount) {
            this.courseCount = courseCount;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public int getEffective() {
            return effective;
        }

        public void setEffective(int effective) {
            this.effective = effective;
        }

        public int getEvalLevel() {
            return evalLevel;
        }

        public void setEvalLevel(int evalLevel) {
            this.evalLevel = evalLevel;
        }

        public String getExamSubject() {
            return examSubject;
        }

        public void setExamSubject(String examSubject) {
            this.examSubject = examSubject;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getOneWord() {
            return oneWord;
        }

        public void setOneWord(String oneWord) {
            this.oneWord = oneWord;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public int getReadCount() {
            return readCount;
        }

        public void setReadCount(int readCount) {
            this.readCount = readCount;
        }

        public long getReplayDate() {
            return replayDate;
        }

        public void setReplayDate(long replayDate) {
            this.replayDate = replayDate;
        }

        public String getReplayUsername() {
            return replayUsername;
        }

        public void setReplayUsername(String replayUsername) {
            this.replayUsername = replayUsername;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int getUseRange() {
            return useRange;
        }

        public void setUseRange(int useRange) {
            this.useRange = useRange;
        }
    }

    public static class EvalBean {
        /**
         * chapterId : 177
         * chapterName : 第一章 导学
         * courseId : 51
         * description : 第一章 导学
         * sectionList : [{"chapterId":177,"free":1,"remark":"","sectionContent":"<p style=\"text-indent:2em;\">\r\n\t<strong>一、教师资格证概述 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2001年，我国开始全面实施教师资格制度。这对于把好教师职业入口关、拓宽教师来源渠道、促进教师专业化、提高教师地位等发挥了重要的作用。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t随着我国经济社会和教育事业的快速发展，社会对教师的资质和品行提出了更高要求，开展中小学和幼儿园教师资格考试改革已经成为加强教师队伍建设的一项重要而紧迫的任务。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t此次改革政策性强，涉及面广、情况复杂且关系到教师资格申请人的切身利益，教育部决定2011年在浙江、湖北两省开展教师资格证考试改革试点工作，经过试点取得经验再于全国展开，迄今为止，考试已经进行了十次。2016年起，青海、四川、广东、重庆、辽宁、黑龙江、天津、云南也纳入了全国统考范围。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t截止2016年上半年，只有新疆、内蒙古、西藏三个地区没有纳入到全国统考范围。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>二、教师资格考试改革试点的目标与任务 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t建立国家教师资格标准，改进考试内容，强化职业道德、心理素养、教育教学能力和专业发展潜质，改革考试形式，加强考试管理，完善考试评价，引导教师教育改革，严把教师职业入口关，结合现在教师公开招聘制度的改革，形成\u201c国标、省考、县聘、校用\u201d的教师准入和管理制度。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>三、教师资格考试改革前和改革后对比<\/strong> \r\n<\/p>\r\n<table width=\"90%\" border=\"2\" cellpadding=\"0\" cellspacing=\"0\">\r\n\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>具体内容 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>改革前 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>改革后 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试形式 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t各省自主命题\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t全国统考\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考生范围 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t非师范类学生与其他社会人员\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t师范生纳入全国统考范围\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试科目 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t教育学<br />\r\n心理学\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t综合素质<br />\r\n教育教学知识与能力<br />\r\n学科教育知识与能力\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试方式 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试+面试\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t机考+笔试+面试\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>考试内容 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t指定的教育学、心理学参考教材\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t不指定统一的参考用书\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>成绩年限 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试成绩长期有效\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t笔试单科成绩有效期2年\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>报考资格 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t大专以上资格即可报考\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t多数考试需要本科以上学历\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>发证时间 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t教学能力测试通过\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t部分科目增加教学实习经验\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"102\">\r\n\t\t\t\t<p align=\"center\">\r\n\t\t\t\t\t<strong>证书有效期 <\/strong> \r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"232\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t未规定\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t\t<td width=\"237\">\r\n\t\t\t\t<p>\r\n\t\t\t\t\t有效期3年，5年一周期定期注册\r\n\t\t\t\t<\/p>\r\n\t\t\t<\/td>\r\n\t\t<\/tr>\r\n\t<\/tbody>\r\n<\/table>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>注<\/strong>：\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1、教师资格证书长期有效。目前部分地区正在试点定期注册，该注册仅限于已进入教师岗位的持证者，要求5年一周期进行注册，未注册通过的取消教师资格。未进入教师岗位的持证者不受定期注册影响，证书依然有效，但一旦从事教学工作后则需进行定期注册；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2、教师资格证笔试单科成绩有效期为2年(登陆成绩查询系统即可查询各科具体失效日期)，有效期内可直接报考面试，过期需重新报考；\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3、教师资格证笔试、面试均合格后可获得《中小学教师资格考试合格证明》，该证明有效期为3年(登陆成绩查询系统即可查询具体失效日期)，有效期内可直接申请认定，过期不能认定需重新考试。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>四、教师资格证考试的类型 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t幼儿园教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t小学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t初级中学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高级中学教师资格证考试\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中等职业学校教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中等职业学校实习指导教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高等学校教师资格\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t注：根据《中华人民共和国教师法》第十三条 普通高等学校的教师资格由国务院或者省、自治区、直辖市教育行政部门或者由其委托的学校认定。高校教师资格证书只允许大学教师或已经签协议在大学工作的聘任制教师办理。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>五、考试方式 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t考试分为笔试和面试两部分。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t幼儿园和小学类别的所有笔试科目采用机考，其余科目采用纸笔考试。笔试各科考试时间均为120分钟。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t目前全国各地区只有上海的幼儿园教师资格考试的笔试科目是全部采用机考，我国其他地区的幼儿园、小学、中学类别还是统一采取笔试的方式。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t面试采用结构化面试、情景模拟等方法，考生通过抽题、备课、试讲、答辩等方式进行。使用教育部考试中心统一研制的面试测评系统。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>六、中学教师资格考试的科目 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t报考初级中学、高级中学、中职文化课教师的考生，笔试分为三个科目：科目一是《综合素质》，科目二是《教育知识与能力》，科目三是《学科知识与教学能力》，面试是《教育教学实践能力》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t初级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、历史与社会、科学等15个学科。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t高级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、通用技术等14个学科。\r\n<\/p>","sectionId":447,"sectionName":"第一节  教师资格证考试介绍","sectionType":1,"sectionUrl":"attached/section/447.html","seq":4470,"testId":447,"timeLength":0},{"chapterId":177,"free":1,"remark":"","sectionContent":"<p style=\"text-indent:2em;\">\r\n\t<strong>一、考试形式 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t改革后，申请教师资格的人员，将由省里自行组织考试改为参加全国统一组织的教师资格考试，即\u201c省考\u201d升为\u201c国考\u201d。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第一、考试内容\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t中学和中职文化课教师增加一个考试科目，合计三门，分别为科目一《综合素质》、科目二《教育知识与能力》和科目三《学科知识与教学能力》。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《学科知识与教学能力》因个人选择的学科不同，考试内容也不同。主要考核个人的专业学历和相对应的教学学科的专业知识及其教学能力，考生应根据自己的需要选择对应的学科。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第二、考试难度\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t从2015年开始，教师资格考试实行全国统考，由教育部统一制定考试标准和考试大纲，组织笔试和面试试题，并建立试题库，考试将按照高考的要求来组织，难度将会大大增加。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第三、考试方式\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t只有上海的幼儿园教师资格考试的笔试科目是全部采用机考，我国其他地区的幼儿园、小学、中学类别还是统一采取笔试的方式。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第四、考试题型\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t不同专业学历所报考学科的考试题型，评分标准都有所不同，同时也没有指定的教材，考生根据自己的需要自行选择教材进行复习。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t第五、成绩年限\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t\u201c省考\u201d的笔试单科成绩有效期为1年，\u201c国考\u201d的笔试单科成绩有效期为2年，如有未通过科目请在下次笔试考试时报考未通过科目，如全部通过笔试科目则等待面试报名期间报考面试。这就意味着，考生第一次考出一门，还有一年半的时间考出其他科目。超过两年未考出资格证，原成绩作废。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t除了以上的不同之外，还有一个重大的变化就是，改革试点启动后，至2012年及以后入学的师范类专业学生，则必须参加国家教师资格证统考，这无疑加强了对师范类学生的专业要求。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t最后，改革后教师的入职门槛提高了，并且打破教师资格终身制，实行定期注册制度。可见，国家将通过改革对教师队伍，进行更加规范化的管理与限制。在公平的教育考试制度下，将会有更多的有志之才，通过自身努力，加入到广大的教师队伍中去。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t<strong>二、学习建议 <\/strong> \r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t1．初步感知，知识点梳理，形成感性经验。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t《综合素质》课程考试涵盖学科的范围较广，包括职业理念、教育法律法规、教师职业道德、文化素养、教师基本能力等内容。只有按照考纲全面要求把握，才能以不变应万变。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t2．形成知识结构，体系。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在初步感知的基础上对每个知识点的内容进行梳理和理解，吃透每个知识点，并对整个学科的知识体系和框架了然于胸，形成自己头脑中的知识结构。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t3．加强理解记忆，巩固知识\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t进一步重复感知、记忆、可结合使用知识点和做练习题穿插进行的方式。对做错的题目进行纠错，并分析做错的原因，并重新回归知识点加强理解和记忆，以巩固知识。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t4．深入掌握并灵活运用知识，提高能力。\r\n<\/p>\r\n<p style=\"text-indent:2em;\">\r\n\t在学习时一定要紧扣考试大纲的要求去学习相关的知识,了解同一知识点的不同变式灵活运用，提高答题做题能力。\r\n<\/p>","sectionId":448,"sectionName":"第二节  注意事项","sectionType":1,"sectionUrl":"attached/section/448.html","seq":4480,"testId":448,"timeLength":0}]
         * seq : 10
         */

        private int chapterId;
        private String chapterName;
        private int courseId;
        private String description;
        private int seq;
        private List<SectionListBean> sectionList;

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public List<SectionListBean> getSectionList() {
            return sectionList;
        }

        public void setSectionList(List<SectionListBean> sectionList) {
            this.sectionList = sectionList;
        }

        public static class SectionListBean {
            /**
             * chapterId : 177
             * free : 1
             * remark :
             * sectionContent : <p style="text-indent:2em;">
             * <strong>一、教师资格证概述 </strong>
             * </p>
             * <p style="text-indent:2em;">
             * 2001年，我国开始全面实施教师资格制度。这对于把好教师职业入口关、拓宽教师来源渠道、促进教师专业化、提高教师地位等发挥了重要的作用。
             * </p>
             * <p style="text-indent:2em;">
             * 随着我国经济社会和教育事业的快速发展，社会对教师的资质和品行提出了更高要求，开展中小学和幼儿园教师资格考试改革已经成为加强教师队伍建设的一项重要而紧迫的任务。
             * </p>
             * <p style="text-indent:2em;">
             * 此次改革政策性强，涉及面广、情况复杂且关系到教师资格申请人的切身利益，教育部决定2011年在浙江、湖北两省开展教师资格证考试改革试点工作，经过试点取得经验再于全国展开，迄今为止，考试已经进行了十次。2016年起，青海、四川、广东、重庆、辽宁、黑龙江、天津、云南也纳入了全国统考范围。
             * </p>
             * <p style="text-indent:2em;">
             * 截止2016年上半年，只有新疆、内蒙古、西藏三个地区没有纳入到全国统考范围。
             * </p>
             * <p style="text-indent:2em;">
             * <strong>二、教师资格考试改革试点的目标与任务 </strong>
             * </p>
             * <p style="text-indent:2em;">
             * 建立国家教师资格标准，改进考试内容，强化职业道德、心理素养、教育教学能力和专业发展潜质，改革考试形式，加强考试管理，完善考试评价，引导教师教育改革，严把教师职业入口关，结合现在教师公开招聘制度的改革，形成“国标、省考、县聘、校用”的教师准入和管理制度。
             * </p>
             * <p style="text-indent:2em;">
             * <strong>三、教师资格考试改革前和改革后对比</strong>
             * </p>
             * <table width="90%" border="2" cellpadding="0" cellspacing="0">
             * <tbody>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>具体内容 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p align="center">
             * <strong>改革前 </strong>
             * </p>
             * </td>
             * <td width="237">
             * <p align="center">
             * <strong>改革后 </strong>
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>考试形式 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 各省自主命题
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 全国统考
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>考生范围 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 非师范类学生与其他社会人员
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 师范生纳入全国统考范围
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>考试科目 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 教育学<br />
             * 心理学
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 综合素质<br />
             * 教育教学知识与能力<br />
             * 学科教育知识与能力
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>考试方式 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 笔试+面试
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 机考+笔试+面试
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>考试内容 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 指定的教育学、心理学参考教材
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 不指定统一的参考用书
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>成绩年限 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 笔试成绩长期有效
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 笔试单科成绩有效期2年
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>报考资格 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 大专以上资格即可报考
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 多数考试需要本科以上学历
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>发证时间 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 教学能力测试通过
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 部分科目增加教学实习经验
             * </p>
             * </td>
             * </tr>
             * <tr>
             * <td width="102">
             * <p align="center">
             * <strong>证书有效期 </strong>
             * </p>
             * </td>
             * <td width="232">
             * <p>
             * 未规定
             * </p>
             * </td>
             * <td width="237">
             * <p>
             * 有效期3年，5年一周期定期注册
             * </p>
             * </td>
             * </tr>
             * </tbody>
             * </table>
             * <p style="text-indent:2em;">
             * <strong>注</strong>：
             * </p>
             * <p style="text-indent:2em;">
             * 1、教师资格证书长期有效。目前部分地区正在试点定期注册，该注册仅限于已进入教师岗位的持证者，要求5年一周期进行注册，未注册通过的取消教师资格。未进入教师岗位的持证者不受定期注册影响，证书依然有效，但一旦从事教学工作后则需进行定期注册；
             * </p>
             * <p style="text-indent:2em;">
             * 2、教师资格证笔试单科成绩有效期为2年(登陆成绩查询系统即可查询各科具体失效日期)，有效期内可直接报考面试，过期需重新报考；
             * </p>
             * <p style="text-indent:2em;">
             * 3、教师资格证笔试、面试均合格后可获得《中小学教师资格考试合格证明》，该证明有效期为3年(登陆成绩查询系统即可查询具体失效日期)，有效期内可直接申请认定，过期不能认定需重新考试。
             * </p>
             * <p style="text-indent:2em;">
             * <strong>四、教师资格证考试的类型 </strong>
             * </p>
             * <p style="text-indent:2em;">
             * 幼儿园教师资格证考试
             * </p>
             * <p style="text-indent:2em;">
             * 小学教师资格证考试
             * </p>
             * <p style="text-indent:2em;">
             * 初级中学教师资格证考试
             * </p>
             * <p style="text-indent:2em;">
             * 高级中学教师资格证考试
             * </p>
             * <p style="text-indent:2em;">
             * 中等职业学校教师资格
             * </p>
             * <p style="text-indent:2em;">
             * 中等职业学校实习指导教师资格
             * </p>
             * <p style="text-indent:2em;">
             * 高等学校教师资格
             * </p>
             * <p style="text-indent:2em;">
             * 注：根据《中华人民共和国教师法》第十三条 普通高等学校的教师资格由国务院或者省、自治区、直辖市教育行政部门或者由其委托的学校认定。高校教师资格证书只允许大学教师或已经签协议在大学工作的聘任制教师办理。
             * </p>
             * <p style="text-indent:2em;">
             * <strong>五、考试方式 </strong>
             * </p>
             * <p style="text-indent:2em;">
             * 考试分为笔试和面试两部分。
             * </p>
             * <p style="text-indent:2em;">
             * 幼儿园和小学类别的所有笔试科目采用机考，其余科目采用纸笔考试。笔试各科考试时间均为120分钟。
             * </p>
             * <p style="text-indent:2em;">
             * 目前全国各地区只有上海的幼儿园教师资格考试的笔试科目是全部采用机考，我国其他地区的幼儿园、小学、中学类别还是统一采取笔试的方式。
             * </p>
             * <p style="text-indent:2em;">
             * 面试采用结构化面试、情景模拟等方法，考生通过抽题、备课、试讲、答辩等方式进行。使用教育部考试中心统一研制的面试测评系统。
             * </p>
             * <p style="text-indent:2em;">
             * <strong>六、中学教师资格考试的科目 </strong>
             * </p>
             * <p style="text-indent:2em;">
             * 报考初级中学、高级中学、中职文化课教师的考生，笔试分为三个科目：科目一是《综合素质》，科目二是《教育知识与能力》，科目三是《学科知识与教学能力》，面试是《教育教学实践能力》。
             * </p>
             * <p style="text-indent:2em;">
             * 初级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、历史与社会、科学等15个学科。
             * </p>
             * <p style="text-indent:2em;">
             * 高级中学《学科知识与教学能力》考试科目分为语文、数学、英语、思想品德（政治）、历史、地理、物理、化学、生物、音乐、体育与健康、美术、信息技术、通用技术等14个学科。
             * </p>
             * sectionId : 447
             * sectionName : 第一节  教师资格证考试介绍
             * sectionType : 1
             * sectionUrl : attached/section/447.html
             * seq : 4470
             * testId : 447
             * timeLength : 0
             */

            private int chapterId;
            private int free;
            private String remark;
            private String sectionContent;
            private int sectionId;
            private String sectionName;
            private int sectionType;
            private String sectionUrl;
            private int seq;
            private int testId;
            private int timeLength;
            private int definition;

            public int getDefinition() {
                return definition;
            }

            public void setDefinition(int definition) {
                this.definition = definition;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getSectionContent() {
                return sectionContent;
            }

            public void setSectionContent(String sectionContent) {
                this.sectionContent = sectionContent;
            }

            public int getSectionId() {
                return sectionId;
            }

            public void setSectionId(int sectionId) {
                this.sectionId = sectionId;
            }

            public String getSectionName() {
                return sectionName;
            }

            public void setSectionName(String sectionName) {
                this.sectionName = sectionName;
            }

            public int getSectionType() {
                return sectionType;
            }

            public void setSectionType(int sectionType) {
                this.sectionType = sectionType;
            }

            public String getSectionUrl() {
                return sectionUrl;
            }

            public void setSectionUrl(String sectionUrl) {
                this.sectionUrl = sectionUrl;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public int getTestId() {
                return testId;
            }

            public void setTestId(int testId) {
                this.testId = testId;
            }

            public int getTimeLength() {
                return timeLength;
            }

            public void setTimeLength(int timeLength) {
                this.timeLength = timeLength;
            }
        }
    }
}
