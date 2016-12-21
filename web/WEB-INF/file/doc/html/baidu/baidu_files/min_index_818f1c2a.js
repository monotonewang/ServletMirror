F._setMod("superpage");
F._fileMap({
    "/js/sbase_63684f6b.js": ["tangram/tangram_min", "lib/base", "lib/mod_evt", "lib/sbase", "lib/log", "lib/class", "lib/exception", "lib/view", "lib/model", "lib/service", "common/image_lazy_load", "common/user_attr", "common/strpx", "common/localstorage", "common/tween"],
    "/js/min_index_14c88814.js": ["config", "log/index_all", "log/page_all", "start/index_start", "ps/log", "ps/sindex", "ps/sug", "page/info", "page/analyse", "news/news"],
    "/js/base_extend_f15404cc.js": ["tangram/tangram_baseall", "tangram/tangram_move", "lib/sbase_extend", "common/tips", "common/pop", "common/select"],
    "/js/news_extend_bf87ca67.js": ["news/hotnews_ext", "news/hotnews_sug", "news/hotnews_sug_job", "news/idio", "news/idio_settings", "news/idio_persons"],
    "/css/news_extend_8411c73a.css": ["news_tip.css", "news_hotword_layer.css", "news_idio.css", "news_settings.css", "idio_tip.css"],
    "/js/min_setting_c9e218fa.js": ["config", "tangram/tangram_baseall", "lib/sbase_extend", "log/setting_all", "common/tips", "common/pop", "common/user_attr", "setting/setting", "setting/tab_mod", "setting/tab_msg", "setting/tab_msg_new", "setting/tab_web", "setting/data_adapter", "start/setting_start", "common/placeholder", "setting/yaohao"],
    "/css/index_min_06223bf4.css": ["index_init.css", "dialog.css", "guide.css", "news.css", "skin.css", "skin_opacity.css"],
    "/css/index_extend_46ff9cb8.css": ["select.css"],
    "/css/setting_all_02817aab.css": ["index_layout.css", "select.css", "index_mod.css", "dialog.css", "setting.css", "setting_mod.css", "setting_msg.css", "setting_yaohao.css"],
    "/js/guide_c61bf555.js": ["common/guide_tip", "news/news_tip", "news/news_ext", "news/idio_tip", "ur/ur_static_superpage"],
    "/js/font_detect_dfcf530f.js": ["page/font_detect"],
    "/css/pop_f45fccad.css": ["pop.css"],
    "/js/birthlogo_5c138b33.js": ["common/spirit_anime", "common/microphone", "common/fx", "logo/spirit", "logo/birthday"],
    "/js/new_guide_c86653a0.js": ["logo/new_guide"],
    "/css/birthlogo_56f14c73.css": ["index_logo.css", "logo_new_guide.css"],
    "/css/ur_static_55c2b682.css": ["ur_urstatic_superpage.css"]
});
F._defService("superpage", {
    lzload: "common/image_lazy_load",
    strpx: "common/strpx",
    pop: "common/pop",
    userAttr: "common/user_attr",
    news: "news/news",
    guidetip: "common/guide_tip",
    localstorage: "common/localstorage",
    baseExtend: "lib/sbase_extend",
    base: "lib/sbase",
    tips: "common/tips",
    hotFail: "hot_fail_tip",
    news: "news/news",
    idioSettings: "news/idio_settings"
});
F._setContext({base: "lib/sbase"});
F.use("lib/mod_evt", function (a) {
    F._setContextMethod("fire", function (c, b) {
        return a.fire(this.svnMod + ":" + this.modName, c, b)
    });
    F._setContextMethod("listen", function (f, g, d) {
        var e = Object.prototype.toString.call(f);
        if (e == "[object String]") {
            if (f.indexOf(":") < 0) {
                f = this.svnMod + ":" + f
            }
        } else {
            if (e == "[object Array]") {
                for (var c = 0, b = f.length; c < b; c++) {
                    if (f[c].indexOf(":") < 0) {
                        f[c] = this.svnMod + ":" + f[c]
                    }
                }
            }
        }
        a.on(f, g, d)
    });
    F._setContextMethod("unListen", function (c, d, b) {
        a.un(this.svnMod + ":" + this.modName, d, b)
    })
});
F.use("lib/exception", function (a) {
    F._setContextMethod("warn", function (b, d, c) {
        a.warn(this.modName, b, d, c)
    });
    F._setContextMethod("fail", function (b, d, c) {
        a.fail(this.modName, b, d, c)
    })
});
F._loadScriptTimeout = 15000;
F._useConfig = true;
F._firstScreenCSS = F._firstScreenCSS || [];
F._firstScreenCSS.push("/css/index_min_06223bf4.css");
F._firstScreenJS = "/js/min_index_14c88814.js";
F.addLog("superpage:page", {
    addBtnClick: "0100400001",
    nplusBackClick: "0800100001",
    feedbackClick: "1000000001",
    feedbackShow: "1000000000"
});
F.addLog("superpage:page", {ikonwClick: "0100800001", guideShown: "0000100000"});
F.addLog("superpage:page", {resClick: "0000100001"});
F.addLog("superpage:news", {
    newUserShow: "0200400000",
    newUserClick: "0200400001",
    hotChangeTipShow: "0200600000",
    hotChangeTipClick: "0200600001",
    newsShow: "0200700000",
    newsClick: "0200700001"
});
F.addLog("superpage:feed", {
    show: "0500000000",
    click: "0500000001",
    moreClick: "0500100001",
    moduleCloseClick: "0500200001"
});
F.addLog("superpage:ps", {
    categoryClick: "0300100001",
    homePageClick: "0300000001",
    queryChange: "0900000001",
    searchBtnClick: "0900000001",
    psLogoClick: "0900100001",
    psWorkLnkClick: "0900200001",
    psShrinkGuideShow: "0800700000",
    psShrinkGuideClick: "0800700001"
});
F.addLog("superpage:yunjf", ["spguide"]);
F.addLog("superpage:logo", {
    logoShow: "1500100000",
    logoClick: "1500100001",
    shareShow: "1500200000",
    playClick: "1500200001"
});
F.addLog("superpage:ur", ["urClick"]);
F.addLog("superpage:feed", ["jsLoadTime"]);
F.addLog("superpage:lib", {jsErrorCaptured: "2000100001"});
F.addLog("superpage:page", ["speed", "cssLoadFailed"]);
F.addLog("superpage:res", ["jsLoadTime"]);
F.use("lib/sbase", function (c) {
    var e = true, f = true, d = true, b = true, a = false;
    c.domReady(function () {
        window._load_status = "dom_ready";
        F.use("page/info");
        F.use("ps/sindex", function (h) {
            h.init()
        });
        if (typeof window._sp_async == "undefined") {
            F.use("ps/sug", function (h) {
                h.init()
            })
        }
        F.use("ps/log", function (h) {
            h.bindBox("nv");
            h.bindBox("u_sp");
            h.bindBox("s_username_menu");
            h.bindBox("s_bottom_prline1");
            c.g("s_pss_exit") && h.bindBox("s_pss_exit")
        });
        if (c.g("toipad")) {
            F.use("setting/toipad", function (h) {
                h.init()
            })
        }
        if (!s_session.userTips.newsHalfVersion) {
            F.use("news/news", function (h) {
                h.init(false)
            })
        }
        F.getService("msg", "start", function (h) {
            h.run()
        });
        F.getService("nav", "start", function (h) {
            h.run()
        });
        F.getService("pack", "start", function (h) {
            h.run()
        });
        c.on(window, "load", function () {
            window._load_status = "window_load";
            F.call("news/news_ext", "init");
            if (s_session.isNewMsg) {
                F.getService("msg", "noticeStart", function (h) {
                    h.init()
                })
            }
            F.getService("pack", "menu", function (h) {
                h.init();
                if (s_session.userTips.news2GuideTip && s_session.userTips.showIdioTab && !s_session.userTips.newsHalfVersion) {
                    F.use("news/news_tip", function (j) {
                        j.init()
                    })
                }
            });
            F.getService("nav", "navGuide", function (h) {
                h.init()
            });
            F.call("ur/ur_static_superpage", "init");
            if (!s_session.logoCode) {
                c.ajax.get(s_domain.baseuri + "/page/data/birthday?asyn=1&t=" + Math.random(), function (h) {
                    if (!h.isBirthday || h.isBirthday != "1") {
                        g(false)
                    } else {
                        F.use("logo/birthday", function (j) {
                            j.beforeInit()
                        });
                        g(true)
                    }
                })
            } else {
                g(false)
            }
            if (window.location.href && window.location.href.indexOf("wwwq.baidu.com") >= 0) {
                c.g("form1").action = "/s"
            }
            window._load_status = "fully_load"
        });
        function g(h) {
            F.getService("skin", "start", function (j) {
                j.run(h)
            })
        }

        c.isIE6 && c.forEach(["resize", "load"], function (h) {
            c.on(window, h, function (j) {
                c.dom.toggleClass(c.g("bottom_container"), "xxx4ielw");
                c.dom.toggleClass(document.body, "rs4ie")
            })
        });
        if (c.getViewHeight() < c.getPageHeight() && !c.isIE6) {
            document.body.style.height = "auto"
        }
        if (c.browser.opera) {
            document.body.style.minHeight = "100px"
        }
        F.fire("superpage:page", "runCssDetect")
    })
});
F.module("ps/log", function (b, e, j) {
    var d = j.base;
    var f = {
        "搜索设置": "tj_setting",
        "返回原版": "tj_origSearch",
        "帐号设置": "tj_user",
        "我的空间": "tj_space",
        "我的相册": "tj_xiangce",
        "首页设置": "tj_msgsetting",
        "返回个人中心": "tj_supper",
        "传统首页": "tj_classic",
        "登录": "tj_login",
        "退出": "tj_logout",
        "新闻": "tj_news",
        "贴吧": "tj_tieba",
        "知道": "tj_zhidao",
        "音乐": "tj_mp3",
        "图片": "tj_img",
        "视频": "tj_video",
        "文库": "tj_wenku",
        "地图": "tj_map",
        "空间": "tj_hi",
        "百科": "tj_baike",
        hao123: "tj_hao123",
        "更多>>": "tj_more",
        "我的主页": "tj_gongzhu",
        "我的成就": "tj_chengjiu",
        "加入百度推广": "tj_ad_join",
        "搜索风云榜": "tj_ad_top",
        "关于百度": "tj_ad_about_ch",
        AboutBaidu: "tj_ad_about_en",
        "加入开放首页": "tj_ad_open",
        "个人中心": "tj_ucent",
        "我的收藏": "tj_ucent_col",
        "我的日历": "tj_ucent_cal",
        "搜索记录": "tj_ucent_his"
    };
    var g = function (n) {
        var m = n.srcElement ? n.srcElement : n.target;
        var l = m.tagName;
        if (m.tagName == "A") {
            var k = a(m);
            if (k in f) {
                j.fire("categoryClick", {category: f[k]})
            } else {
                if (k == s_session.username) {
                    j.fire("categoryClick", {category: "username"})
                }
            }
        }
    };
    var a = function (k) {
        return d.getText(k).replace(/[\s\t\xa0\u3000]/g, "")
    };

    function c(k) {
        d.on(k, "mousedown", g)
    }

    function h(k) {
        j.fire("categoryClick", {category: k})
    }

    e.bindBox = c;
    e.fireLog = h
});
F.module("ps/sindex", function (d, c, b) {
    var e = b.base;
    c.init = function () {
        var t = {
            "http://news.baidu.com/": "ns?tn=news&cl=2&rn=20&ct=1&ie=utf-8&word=",
            "http://tieba.baidu.com/": "f?ie=utf-8&kw=",
            "http://zhidao.baidu.com/": "search?pn=0&rn=10&lm=0&word=",
            "http://music.baidu.com/": "search?fr=sp&ie=utf-8&key=",
            "http://image.baidu.com/": "i?ct=201326592&cl=2&nc=1&lm=-1&st=-1&tn=baiduimage&istype=2&fm=&pv=&z=0&ie=utf-8&word=",
            "http://v.baidu.com/": "v?ct=301989888&s=25&ie=utf-8&word=",
            "http://map.baidu.com/": "?newmap=1&ie=utf-8&s=s%26wd%3D",
            "http://baike.baidu.com/": "search/word?&pic=1&sug=1&enc=utf8&word=",
            "http://wenku.baidu.com/": "search?ie=utf-8&word="
        };
        var p = window, D = document, x = navigator, z = e.g("kw1"), H = D.getElementById("nv").getElementsByTagName("a"), u = x.userAgent.indexOf("MSIE") != -1 && !window.opera;
        for (var A = 0; A < H.length; A++) {
            H[A].onclick = function () {
                var n = e.trim(z.value);
                var k = false;
                var K = baidu.packPlayer;
                if (K && !s_session.userProp.searchAgroupGuide) {
                    var L = this;
                    if (K.getState() == "play" && s_session.yuce && s_session.yuce != "1") {
                        L.target = "_blank";
                        k = true
                    } else {
                        L.target = "_self";
                        k = false
                    }
                }
                if (n.length > 0) {
                    var L = this, w = L.href, J = encodeURIComponent(n);
                    if (!t[this.href]) {
                        return true
                    }
                    this.href = w + t[w] + J;
                    if (s_session.userProp.searchAgroupGuide || k) {
                        setTimeout(function () {
                            e.g("kw1").value = "";
                            e.g("kw1").focus();
                            L.href = w.match(/http:\/\/.*\//i)[0]
                        }, 1)
                    }
                }
            }
        }
        function y(w, n, k) {
            if (p.attachEvent) {
                w.attachEvent("on" + n, k)
            } else {
                if (p.addEventListener) {
                    w.addEventListener(n, k, false)
                }
            }
        }

        function q(k) {
            return D.getElementById(k)
        }

        var l = x.cookieEnabled;
        if (typeof window._sp_async == "undefined") {
            e.on(window, "load", function () {
                if (true && l && /\bbdime=[12]/.test(D.cookie)) {
                    E(b.domain.staticUrl + "static/superpage/js/ps/openime_daa063b1.js", "utf-8")
                }
            })
        }
        try {
            if (typeof window._sp_async == "undefined") {
                e.g("kw1") && e.g("kw1").focus()
            } else {
                if (pageState == 0) {
                    e.g("kw1") && e.g("kw1").focus()
                }
            }
        } catch (B) {
        }
        var j = [false, false];
        var h = false;

        function o(n, w, k) {
            e.on(e.g(n), "mouseover", function (J) {
                j[k] = true;
                e.show(w);
                if (!h) {
                    F.use("ps/log", function (K) {
                        K.fireLog("tj_ucent_mouseover")
                    });
                    h = true;
                    setTimeout(function () {
                        h = false
                    }, 1000)
                }
            });
            e.on(e.g(n), "mouseout", function (J) {
                j[k] = false;
                window.setTimeout(function () {
                    if (!j[k]) {
                        e.hide(w)
                    }
                }, 200)
            })
        }

        o("s_username_top", "s_username_menu", 0);
        o("s_username_menu", "s_username_menu", 0);
        (function f() {
            var J = "http://www.baidu.com/";
            if (u) {
                try {
                    var k = document.getElementById("s_seth");
                    if (k) {
                        if (e.isBaidu) {
                            k.innerHTML = "<a href='http://www.baidu.com/cache/sethelp/index.html' onclick='_onS_sethClick();' target=_blank>把百度设为主页</a>"
                        }
                        var n = k.isHomePage(J);
                        k.style.visibility = n ? "hidden" : "visible";
                        b.fire("homePageShow")
                    }
                } catch (w) {
                }
            } else {
                var k = document.getElementById("s_seth");
                if (k) {
                    k.innerHTML = "<a href='http://www.baidu.com/cache/sethelp/index.html' onclick='_onS_sethClick();' target=_blank>把百度设为主页</a>";
                    k.style.visibility = "visible";
                    b.fire("homePageShow")
                }
            }
        })();
        window._onS_sethClick = function () {
            b.fire("homePageClick")
        };
        function E(k, w) {
            if (k) {
                var n = D.createElement("script");
                n.charset = w ? w : "gbk";
                n.src = k;
                D.getElementsByTagName("head")[0].appendChild(n)
            }
        }

        y(p, "load", function () {
            try {
                e.g("kw1").focus()
            } catch (k) {
            }
        });
        p.onunload = function () {
        };
        var I = e.g("s_mp");
        var m;
        if (I) {
            m = I.getElementsByTagName("area")[0]
        }
        var r = e.g("lm").getElementsByTagName("a")[0];
        m && e.on(m, "click", function (k) {
            b.fire("psLogoClick", {isFesBg: (s_session.userTips.skinLogoHasSkined ? "true" : "false")})
        });
        r && e.on(r, "click", function (k) {
            b.fire("psWorkLnkClick")
        });
        if (!s_session.userProp.searchAgroupGuide && s_session.userTips.showFmSearchGuide == true && (typeof window._sp_async == "undefined")) {
            var v = e.g("kw1"), s = e.g("s_fm");
            e.on(v, "keyup", function () {
                if (g()) {
                    C()
                }
            });
            e.on(v, "mouseup", function () {
                if (g()) {
                    C()
                }
            });
            var g = function () {
                return (baidu.packPlayer && baidu.packPlayer.getState() == "play")
            };
            var C = function () {
                if (e.g("bd_fm_search_tip")) {
                    return
                }
                F.use("common/guide_tip", function (n) {
                    var k = n.render({
                        id: "bd_fm_search_tip",
                        arrowPosLeft: 40,
                        arrowType: "up",
                        width: 280,
                        pos: {left: 555, top: 35},
                        content: "<div class='icon'></div><em>您正在听歌，本次搜索结果将新窗口打开。</em>",
                        hasClose: true
                    });
                    e.insertHTML(s, "beforeEnd", k);
                    F.use("common/user_attr", function (K) {
                        K.setAttr("showFmSearchGuide", false)
                    });
                    var w = e.g("bd_fm_search_tip");
                    e.setStyle(w, "z-index", "999");
                    var J = e.q("guide-tip-close", w)[0];
                    e.on(J, "click", function () {
                        e.setStyle(w, "display", "none")
                    })
                })
            }
        }
    };
    var a = function () {
        e.setStyle("s_pss_guide", "width", (document.body.clientWidth <= 958) ? "958px" : "100%")
    }
});
var isIE = navigator.userAgent.indexOf("MSIE") != -1 && !window.opera;
function G(a) {
    return document.getElementById(a)
}
function addEV(c, b, a) {
    if (window.attachEvent) {
        c.attachEvent("on" + b, a)
    } else {
        if (window.addEventListener) {
            c.addEventListener(b, a, false)
        }
    }
}
var bds = bds || {};
bds.se = bds.se || {};
bds.se.store = (function () {
    var r = {}, v = window, s = v.document, z = "localStorage", e = "globalStorage", y = "__storejs__", w;
    r.disabled = false;
    r.set = function (b, a) {
    };
    r.get = function (a) {
    };
    r.remove = function (a) {
    };
    r.clear = function () {
    };
    r.transact = function (d, a, c) {
        var b = r.get(d);
        if (c == null) {
            c = a;
            a = null
        }
        if (typeof b == "undefined") {
            b = a || {}
        }
        c(b);
        r.set(d, b)
    };
    r.getAll = function () {
    };
    r.serialize = function (a) {
        return String(a)
    };
    r.deserialize = function (a) {
        if (typeof a != "string") {
            return undefined
        }
        return a
    };
    function A() {
        try {
            return (z in v && v[z])
        } catch (a) {
            return false
        }
    }

    function p() {
        try {
            return (e in v && v[e] && v[e][v.location.hostname])
        } catch (a) {
            return false
        }
    }

    if (A()) {
        w = v[z];
        r.set = function (b, a) {
            if (a === undefined) {
                return r.remove(b)
            }
            w.setItem(b, r.serialize(a))
        };
        r.get = function (a) {
            return r.deserialize(w.getItem(a))
        };
        r.remove = function (a) {
            w.removeItem(a)
        };
        r.clear = function () {
            w.clear()
        };
        r.getAll = function () {
            var c = {};
            for (var a = 0; a < w.length; ++a) {
                var b = w.key(a);
                c[b] = r.get(b)
            }
            return c
        }
    } else {
        if (p()) {
            w = v[e][v.location.hostname];
            r.set = function (b, a) {
                if (a === undefined) {
                    return r.remove(b)
                }
                w[b] = r.serialize(a)
            };
            r.get = function (a) {
                return r.deserialize(w[a] && w[a].value)
            };
            r.remove = function (a) {
                delete w[a]
            };
            r.clear = function () {
                for (var a in w) {
                    delete w[a]
                }
            };
            r.getAll = function () {
                var c = {};
                for (var a = 0; a < w.length; ++a) {
                    var b = w.key(a);
                    c[b] = r.get(b)
                }
                return c
            }
        } else {
            if (s.documentElement.addBehavior) {
                var t, x;
                try {
                    x = new ActiveXObject("htmlfile");
                    x.open();
                    x.write('<script>document.w=window<\/script><iframe src="/favicon.ico"></iframe>');
                    x.close();
                    t = x.w.frames[0].document;
                    w = t.createElement("div")
                } catch (u) {
                    w = s.createElement("div");
                    t = s.body
                }
                function B(a) {
                    return function () {
                        var b = Array.prototype.slice.call(arguments, 0);
                        b.unshift(w);
                        t.appendChild(w);
                        w.addBehavior("#default#userData");
                        w.load(z);
                        var c = a.apply(r, b);
                        t.removeChild(w);
                        return c
                    }
                }

                function q(a) {
                    return "_" + a
                }

                r.set = B(function (a, c, b) {
                    c = q(c);
                    if (b === undefined) {
                        return r.remove(c)
                    }
                    a.setAttribute(c, r.serialize(b));
                    a.save(z)
                });
                r.get = B(function (b, a) {
                    a = q(a);
                    return r.deserialize(b.getAttribute(a))
                });
                r.remove = B(function (b, a) {
                    a = q(a);
                    b.removeAttribute(a);
                    b.save(z)
                });
                r.clear = B(function (a) {
                    var d = a.XMLDocument.documentElement.attributes;
                    a.load(z);
                    for (var b = 0, c; c = d[b]; b++) {
                        a.removeAttribute(c.name)
                    }
                    a.save(z)
                });
                r.getAll = B(function (a) {
                    var f = a.XMLDocument.documentElement.attributes;
                    a.load(z);
                    var c = {};
                    for (var b = 0, d; d = f[b]; ++b) {
                        c[d] = r.get(d)
                    }
                    return c
                })
            }
        }
    }
    try {
        r.set(y, y);
        if (r.get(y) != y) {
            r.disabled = true
        }
        r.remove(y)
    } catch (u) {
        r.disabled = true
    }
    return r
})();
bds.se.sugStorage = (function () {
    var g, a, c, o = "BDSUGSTORED", n = "__OPTIONS__";
    var b = (function () {
        var w = /['"\\\/\<\>\n\r]/g, v = {
            "'": "\\x27",
            '"': "\\x22",
            "\\": "\\\\",
            "/": "\\/",
            "\n": "\\\\n",
            "\r": "\\\\r",
            "<": "&lt;",
            ">": "&gt;"
        };
        var u = function (x) {
            return v[x] || x
        };
        return function (x) {
            return x.replace(w, u)
        }
    })();
    var r = function () {
        return '{"q": "' + this.q + '", "p": "' + (this.p ? this.p : "") + '"}'
    };
    var h = function (w) {
        var u = [];
        for (var v in w) {
            u.push('"' + v + '": "' + w[v] + '"')
        }
        return "{" + u.join(",") + "}"
    };
    var f = function (u, v) {
        if (v !== undefined) {
            c[u] = v;
            bds.se.store.set(n, h(c));
            return v
        }
        return c[u] || ""
    };
    var t = function () {
        return bds.se.store && !bds.se.store.disabled
    };
    var e = function (v) {
        if (v && v.q && v.p) {
            v.toString = r;
            if (!(a[v.q] && a[v.p])) {
                g.push(v)
            } else {
                for (var x = 0, y = 0; x < g.length; x++) {
                    if (v.q == g[x].q && v.p == g[x].p) {
                        y = 1;
                        break
                    }
                }
                if (y === 0) {
                    g.push(v)
                }
            }
            if (a[v.q] == undefined) {
                a[v.q] = [v]
            } else {
                for (var w = 0, y = 0, u = a[v.q].length; w < u; w++) {
                    if (a[v.q][w].p == v.p || a[v.q][w].q == v.q) {
                        y = 1;
                        break
                    }
                }
                if (y === 0) {
                    a[v.q].push(v)
                }
            }
            if (a[v.p] == undefined) {
                a[v.p] = [v]
            } else {
                for (var w = 0, y = 0, u = a[v.p].length; w < u; w++) {
                    if (a[v.p][w].q == v.q) {
                        y = 1;
                        break
                    }
                }
                if (y === 0) {
                    a[v.p].push(v)
                }
            }
            bds.se.store.set(o, "[" + g.join(",") + "]");
            return g.length
        }
        return false
    };
    var p = function (w) {
        var u = [];
        for (var v in a) {
            if (new RegExp("^" + w, "img").test(v)) {
                u = u.concat(a[v])
            }
        }
        return u
    };
    var j = function (u) {
        return g
    };
    var q = function () {
        g = [];
        a = {};
        bds.se.store.set(o, "");
        return g.length
    };
    var m = function () {
        return g.length
    };
    var s = function (u) {
        if (!u || !u.q || !u.p) {
            return false
        }
        var v;
        for (i = 0; i < g.length; i++) {
            if (u.q == g[i].q && u.p == g[i].p) {
                v = g[i];
                g.splice(i, 1);
                break
            }
        }
        if (v === undefined) {
            return false
        } else {
            bds.se.store.set(o, "[" + g.join(",") + "]");
            l();
            return v
        }
    };
    var k = function (u) {
        if (s(u)) {
            return e({q: u.q, p: u.p})
        }
        return false
    };
    var d = function () {
        var u = g[0];
        if (u) {
            return s({q: u.q, p: u.p})
        }
        return false
    };
    var l = function () {
        a = {};
        var B = bds.se.store.get(n);
        if (B) {
            c = (new Function("return (" + B + ")"))()
        } else {
            c = {}
        }
        var w = bds.se.store.get(o);
        if (!w) {
            g = []
        } else {
            g = (new Function("return (" + w + ")"))();
            for (var z = 0, v = g.length; z < v; z++) {
                var x = g[z];
                x.toString = r;
                if (a[x.q] == undefined) {
                    a[x.q] = [x]
                } else {
                    for (var y = 0, A = 0, u = a[x.q].length; y < u; y++) {
                        if (a[x.q][y].p == x.p || a[x.q][y].q == x.q) {
                            A = 1;
                            break
                        }
                    }
                    if (A === 0) {
                        a[x.q].push(x)
                    }
                }
                if (a[x.p] == undefined) {
                    a[x.p] = [x]
                } else {
                    for (var y = 0, A = 0, u = a[x.p].length; y < u; y++) {
                        if (a[x.p][y].q == x.q) {
                            A = 1;
                            break
                        }
                    }
                    if (A === 0) {
                        a[x.p].push(x)
                    }
                }
            }
        }
    };
    l();
    return {
        escapeData: b,
        isSupport: t,
        reset: q,
        getCount: m,
        set: e,
        get: p,
        getAll: j,
        edit: k,
        remove: s,
        pop: d,
        option: f
    }
})();
bds.se.sugsync = function () {
    var q;
    var m = 0, k = 0, j = 0, x = 0, d = false, b = null;
    var r = (/msie (\d+)/i.test(navigator.userAgent) && !window.opera) ? parseInt(RegExp.$1) : 0;
    var B = (document.compatMode == "BackCompat");

    function l(C) {
        return document.getElementById(C)
    }

    function o(C) {
        return document.createElement(C)
    }

    function y(C) {
        return String(C).replace(new RegExp("(^[\\s\\t\\xa0\\u3000]+)|([\\u3000\\xa0\\s\\t]+\x24)", "g"), "")
    }

    function A(C) {
        return String(C).replace(new RegExp("[\\s\\t\\xa0\\u3000]", "g"), "")
    }

    function u(H, E, C) {
        if (r) {
            H.attachEvent("on" + E, (function (I) {
                return function () {
                    C.call(I)
                }
            })(H))
        } else {
            H.addEventListener(E, C, false)
        }
    }

    function s(C) {
        if (r) {
            C.returnValue = false
        } else {
            C.preventDefault()
        }
    }

    function w(E) {
        if (r) {
            var H = document.createStyleSheet();
            H.cssText = E
        } else {
            var C = document.createElement("style");
            C.type = "text/css";
            C.appendChild(document.createTextNode(E));
            document.getElementsByTagName("HEAD")[0].appendChild(C)
        }
    }

    function h(I) {
        var H = document.forms[0];
        for (var E in I) {
            if (I[E] == undefined) {
                if (l("bdsug_ipt_" + E)) {
                    H.removeChild(l("bdsug_ipt_" + E))
                }
            } else {
                if (!t(E)) {
                    H.appendChild(C(E, I[E]))
                } else {
                    t(E).value = I[E]
                }
            }
        }
        function C(L, J) {
            var K = o("INPUT");
            K.type = "hidden";
            K.name = L;
            K.id = "bdsug_ipt_" + L;
            K.value = J;
            return K
        }
    }

    function t(H) {
        var I = document.forms[0];
        var J = false;
        var C = I.getElementsByTagName("INPUT");
        for (var E = 0; E < C.length; E++) {
            if (H == C[E].getAttribute("name")) {
                J = C[E];
                return J
            } else {
                J = false
            }
        }
    }

    function p(H) {
        var E = document.forms[0];
        for (var C in H) {
            if (C == "f") {
                if (t("f")) {
                    if (t("f").id == "bdsug_ipt_f") {
                        E.removeChild(l("bdsug_ipt_f"))
                    } else {
                        t("f").value = "8"
                    }
                }
            } else {
                if (l("bdsug_ipt_" + C)) {
                    E.removeChild(l("bdsug_ipt_" + C))
                }
            }
        }
    }

    var a = 0;
    if (typeof window.bdsug != "object" || window.bdsug == null) {
        window.bdsug = {}
    }
    bdsug.sug = {};
    bdsug.sugkeywatcher = {};
    var n = (function () {
        function C(H) {
            var J = this.__MSG_QS__;
            if (!J[H]) {
                J[H] = []
            }
            for (var I = 1, L = arguments.length, K; I < L; I++) {
                J[H].push(arguments[I])
            }
        }

        function E(J) {
            var I = this.__MSG_QS__[J.type];
            if (I == null) {
                return
            }
            for (var H = 0, K = I.length; H < K; H++) {
                I[H].rm(J)
            }
        }

        return {
            ini: function (H) {
                H.__MSG_QS__ = {};
                H.on = C;
                H.dm = E;
                return H
            }
        }
    })();
    var g = (function () {
        var X = l("kw1");
        var O;
        var L = 0;
        var Z = 0;
        var Q = "";
        var W = "";
        var R;
        var I = false;
        var T = true;
        var M;
        var J = l("su1");
        u(J, "mousedown", V);
        u(J, "keydown", V);
        u(l("kw1"), "paste", function () {
            h({rsv_n: 2});
            if (a == 0) {
                a = new Date().getTime()
            }
        });
        function V() {
            h({inputT: a > 0 ? (new Date().getTime() - a) : 0})
        }

        function U() {
            if (T) {
                g.dm({type: "start"});
                T = false
            }
        }

        function P(aa) {
            if (a == 0) {
                a = new Date().getTime()
            }
            if (T) {
                g.dm({type: "start"});
                T = false
            }
            aa = aa || window.event;
            if (aa.keyCode == 9 || aa.keyCode == 27) {
                g.dm({type: "hide_div"})
            }
            if (aa.keyCode == 13 && window.opera) {
                s(aa);
                g.dm({type: "key_enter"})
            }
            if (aa.keyCode == 86 && aa.ctrlKey) {
                h({rsv_n: 2})
            }
            if (O.style.display != "none") {
                if (aa.keyCode == 38) {
                    s(aa);
                    g.dm({type: "key_up"})
                }
                if (aa.keyCode == 40) {
                    g.dm({type: "key_down"})
                }
            } else {
                if (aa.keyCode == 38 || aa.keyCode == 40) {
                    g.dm({type: "need_data", wd: X.value})
                }
            }
        }

        function H() {
            var aa = X.value;
            if (aa == Q && aa != "" && aa != W && aa != R) {
                if (Z == 0) {
                    Z = setTimeout(function () {
                        g.dm({type: "need_data", wd: aa})
                    }, 100)
                }
            } else {
                clearTimeout(Z);
                Z = 0;
                Q = aa;
                if (aa == "") {
                    g.dm({type: "hide_div"})
                }
                if (W != X.value) {
                    W = ""
                }
            }
        }

        function E() {
            if (!L) {
                L = setInterval(H, 30)
            }
        }

        function N() {
            clearInterval(L);
            L = 0
        }

        function K() {
            if (I) {
                window.event.cancelBubble = true;
                window.event.returnValue = false;
                I = false
            }
        }

        function S(aa) {
            X.blur();
            X.setAttribute("autocomplete", aa);
            X.focus()
        }

        function Y(aa) {
            var aa = aa || window.event;
            if (aa.keyCode == 13) {
                s(aa)
            }
        }

        X.setAttribute("autocomplete", "off");
        var C = false;
        bdsug.sugkeywatcher.on = function () {
            if (!C) {
                if (r) {
                    X.attachEvent("onkeydown", P)
                } else {
                    X.addEventListener("keydown", P, false)
                }
                C = true
            }
        };
        bdsug.sugkeywatcher.off = function () {
            if (C) {
                if (r) {
                    X.detachEvent("onkeydown", P)
                } else {
                    X.removeEventListener("keydown", P, false)
                }
                C = false
            }
        };
        bdsug.sugkeywatcher.on();
        u(X, "blur", N);
        u(X, "focus", E);
        u(X, "mousedown", U);
        u(X, "beforedeactivate", K);
        if (window.opera) {
            u(X, "keypress", Y)
        }
        return n.ini({
            rm: function (aa) {
                switch (aa.type) {
                    case"div_ready":
                        O = aa.sdiv;
                        W = X.value;
                        E();
                        break;
                    case"clk_submit":
                        X.blur();
                        X.value = aa.wd;
                        break;
                    case"ent_submit":
                        N();
                        X.blur();
                        break;
                    case"key_select":
                        R = aa.selected;
                        break;
                    case"close":
                        N();
                        S("on");
                        break;
                    case"mousedown_tr":
                        if (navigator.userAgent.toLowerCase().indexOf("webkit") != -1) {
                            N();
                            setTimeout(E, 2000)
                        }
                        I = true;
                        break
                }
            }
        })
    })();
    var D = (function () {
        var P;
        var X = l("kw1");
        var K;
        var T = -1;
        var ac;
        var W;
        var J;
        var E;

        function H() {
            var ad = K.rows;
            for (var ae = 0; ae < ad.length; ae++) {
                ad[ae].className = "ml"
            }
        }

        function S() {
            if (typeof(K) != "undefined" && K != null && P.style.display != "none") {
                var ad = K.rows;
                for (var ae = 0; ae < ad.length; ae++) {
                    if (ad[ae].className == "mo") {
                        return [ae, ad[ae].cells[0].innerHTML]
                    }
                }
            }
            return [-1, ""]
        }

        function O() {
            if (r && r <= 6) {
                E && (E.style.display = "none")
            }
            P && (P.style.display = "none")
        }

        function ab() {
            H();
            this.className = "mo"
        }

        function V(ad) {
            D.dm({type: "mousedown_tr"});
            if (!r) {
                ad.stopPropagation();
                ad.preventDefault();
                return false
            }
        }

        function U(ae) {
            var ad = ae;
            return function () {
                var af = ac[ad].value;
                O();
                var ag = 0;
                if (typeof ac[ad].ala != "undefined") {
                    ag = W[ac[ad].ala].id
                }
                D.dm({type: "clk_submit", oq: l("kw1").value, wd: af, rsp: ad, rsv_sug5: ag})
            }
        }

        function R(ad) {
            ad = ad || window.event;
            s(ad);
            D.dm({type: "close"});
            O();
            (new Image()).src = "http://sclick.baidu.com/w.gif?fm=suggestion&title=%B9%D8%B1%D5&t=" + new Date().getTime()
        }

        function aa() {
            var ad = [X.offsetWidth, X.offsetHeight];
            P.style.width = ((r && B) ? ad[0] : ad[0] - 2) + "px";
            P.style.top = ((r && B) ? ad[1] : ad[1] - 1) + "px";
            P.style.display = "block";
            if (r && r <= 6) {
                E.style.top = ((r && B) ? ad[1] : ad[1] - 1) + "px";
                E.style.width = ((r && B) ? ad[0] : ad[0] - 2) + "px"
            }
        }

        function Z(ae, af) {
            if (ae && af) {
                var ad = y(ae);
                if (af.indexOf(ad) == 0) {
                    af = C(af, ad)
                } else {
                    if (af.indexOf(A(ae)) == 0) {
                        ad = A(ae);
                        af = C(af, ad)
                    } else {
                        af = af.replace(/&/g, "&amp;");
                        af = af.replace(/</g, "&lt;");
                        af = af.replace(/>/g, "&gt;")
                    }
                }
            }
            return af
        }

        function C(ah, af) {
            ah = ah.replace(/&/g, "&amp;");
            ah = ah.replace(/</g, "&lt;");
            ah = ah.replace(/>/g, "&gt;");
            af = af.replace(/&/g, "&amp;");
            af = af.replace(/</g, "&lt;");
            af = af.replace(/>/g, "&gt;");
            var ae = "<span>" + af + "</span>";
            var ad = af.length;
            var ag = "<b>" + ah.substring(ad) + "</b>";
            return (ae + ag)
        }

        function N(ah) {
            var ae = l("kw1").value, af = /[^\x00-\xff]/g, al = [], ak = [];
            q = 0;
            for (var ai = 0; ai < ah.length; ai++) {
                var am = {};
                am.value = ah[ai];
                am.from = 0;
                al.push(am)
            }
            if (!bds.se.sugStorage.isSupport() || !navigator.cookieEnabled || (!!/\bsugstore=(\d)/.exec(document.cookie) && /\bsugstore=(\d)/.exec(document.cookie)[1] == 0)) {
                return al
            } else {
                if (ae.replace(af, "mm").length <= 3) {
                    return al
                } else {
                    for (var ai = 0; ai < ah.length; ai++) {
                        var am = {};
                        am.value = ah[ai];
                        am.from = 0;
                        al.push(am)
                    }
                    var aj = bds.se.sugStorage.get(encodeURIComponent(ae));
                    aj.sort(function (ao, an) {
                        if (typeof ao.date == "undefined" || typeof an.date == "undefined") {
                            return true
                        } else {
                            return ao.date - an.date
                        }
                    });
                    for (ai = 0; ai < aj.length; ai++) {
                        for (var ag = ai + 1; ag < aj.length; ag++) {
                            if (aj[ai].q == aj[ag].q) {
                                aj.splice(ag, 1);
                                ag--
                            }
                        }
                    }
                    for (ai = aj.length - 1; ai >= 0; ai--) {
                        var am = {};
                        am.value = decodeURIComponent(aj[ai].q);
                        am.from = 1;
                        am.p = aj[ai].p;
                        ak.push(am);
                        q++;
                        if (ai == aj.length - 2) {
                            break
                        }
                    }
                    ah = ak.concat(al);
                    for (ai = 0; ai < ah.length; ai++) {
                        for (ag = ai + 1; ag < ah.length; ag++) {
                            if (ah[ai].value == ah[ag].value) {
                                ah.splice(ag, 1);
                                ag--
                            }
                        }
                    }
                    var ad = [];
                    for (var ai = 0; ai < W.length; ai++) {
                        for (var ag = 0; ag < ah.length; ag++) {
                            if (W[ai].key == ah[ag].value) {
                                if (ah[ag].from == 1) {
                                    q--
                                }
                                ah.splice(ag, 1)
                            }
                        }
                        var am = {};
                        am.value = W[ai].key;
                        am.from = 0;
                        am.ala = ai;
                        ad.unshift(am)
                    }
                    ah = ad.concat(ah);
                    while (ah.length > 10) {
                        ah.pop()
                    }
                    return ah
                }
            }
        }

        function M() {
            function ad(al) {
                if (!al || !al.title) {
                    return
                }
                setTimeout(function () {
                    al.title = ""
                }, 2000)
            }

            ac = N(ac);
            if (ac.length <= 0) {
                O();
                return
            }
            K = o("TABLE");
            K.id = "st";
            K.cellSpacing = 0;
            K.cellPadding = 2;
            var ah = o("tbody");
            K.appendChild(ah);
            for (var ag = 0, ae = ac.length; ag < ae; ag++) {
                var ai = ah.insertRow(-1);
                u(ai, "mouseover", ab);
                u(ai, "mouseout", H);
                u(ai, "mousedown", V);
                u(ai, "click", U(ag));
                var ak = ai.insertCell(-1);
                var aj = Z(J, ac[ag].value);
                if (ac[ag].from == 1) {
                    aj = '<u class="sug_del" title="如您不需要此搜索历史提示，&#13;可在右上角搜索设置中关闭">删除</u>' + aj;
                    ak.className = "sug_storage"
                }
                if (typeof ac[ag].ala != "undefined") {
                    ak.innerHTML = I(aj, ac[ag].ala);
                    ak.className = "sug_ala"
                } else {
                    ak.innerHTML = aj
                }
            }
            P.innerHTML = "";
            P.appendChild(K);
            aa();
            if (r && r <= 6) {
                E.style.display = "block";
                E.style.left = 0 + "px";
                E.style.top = X.offsetHeight + "px";
                E.style.width = X.offsetWidth + "px";
                E.style.height = P.offsetHeight - 1 + "px"
            }
            var af = P.getElementsByTagName("u");
            for (var ag = 0; ag < af.length; ag++) {
                af[ag].onclick = function (ao) {
                    var am = S()[0];
                    var ao = ao || window.event;
                    var an = ao.target || ao.srcElement;
                    an.parentNode.parentNode.parentNode.removeChild(an.parentNode.parentNode);
                    if (r && r <= 6) {
                        E.style.height = P.offsetHeight - 1 + "px"
                    }
                    var al = window["BD_PS_C" + (new Date()).getTime()] = new Image();
                    al.src = "http://sclick.baidu.com/w.gif?q=" + encodeURIComponent(ac[am].value) + "&fm=beha&rsv_sug=del&rsv_sid=11&t=" + new Date().getTime() + "&path=http://www.baidu.com";
                    bds.se.sugStorage.remove({q: encodeURIComponent(ac[am].value), p: ac[am].p});
                    ac.splice(am, 1);
                    D.dm({type: "update_data", word: l("kw1").value, data: ac});
                    if (q > 0) {
                        q--
                    }
                    if (q <= 0 && ac.length == 0) {
                        O();
                        P.innerHTML = ""
                    }
                    if (window.event) {
                        ao.cancelBubble = true
                    } else {
                        ao.stopPropagation()
                    }
                }
            }
            h({rsv_sug: q})
        }

        function I(ae, af) {
            var ad = [];
            switch (W[af].type) {
                case"1":
                    ad.push("<h3>" + W[af].key + "</h3>");
                    ad.push("<p>" + W[af].word);
                    if (W[af].word_add) {
                        ad.push(" <span>（" + W[af].word_add + "）</span>")
                    }
                    ad.push("</p>");
                    break;
                case"2":
                    ad.push("<h3>" + W[af].key + " - 百度安全认证</h3>");
                    ad.push("<p>" + W[af].word);
                    if (W[af].word_add) {
                        ad.push(" <span>（" + W[af].word_add + "）</span>")
                    }
                    ad.push("</p>");
                    break;
                default:
                    ad.push(ae)
            }
            return ad.join("")
        }

        function Y() {
            T = S()[0];
            if (T == -1) {
                D.dm({type: "submit"})
            } else {
                D.dm({type: "ent_submit", oq: J, wd: S()[1], rsp: T})
            }
        }

        function L() {
            T = S()[0];
            H();
            if (T == 0) {
                D.dm({type: "key_select", selected: ""});
                l("kw1").value = J;
                T--;
                p({oq: J, sug: ac[T], rsv_n: 1, rsp: T, f: 3, rsv_sug: rsv_sug, rsv_sug5: 0})
            } else {
                if (T == -1) {
                    T = ac.length
                }
                T--;
                var ad = K.rows[T];
                ad.className = "mo";
                D.dm({type: "key_select", selected: ac[T].value});
                l("kw1").value = ac[T].value;
                var ae = 0;
                if (typeof ac[T].ala != "undefined") {
                    ae = W[ac[T].ala].id
                }
                h({oq: J, sug: ac[T].value, rsv_n: 1, rsp: T, f: 3, rsv_sug: rsv_sug})
            }
        }

        function Q() {
            T = S()[0];
            H();
            if (T == ac.length - 1) {
                D.dm({type: "key_select", selected: ""});
                l("kw1").value = J;
                T = -1;
                p({oq: J, sug: ac[T], rsv_n: 1, rsp: T, f: 3, rsv_sug: rsv_sug, rsv_sug5: 0})
            } else {
                T++;
                var ad = K.rows[T];
                ad.className = "mo";
                D.dm({type: "key_select", selected: ac[T].value});
                l("kw1").value = ac[T].value;
                var ae = 0;
                if (typeof ac[T].ala != "undefined") {
                    ae = W[ac[T].ala].id
                }
                h({oq: J, sug: ac[T].value, rsv_n: 1, rsp: T, f: 3, rsv_sug: rsv_sug, rsv_sug5: ae})
            }
        }

        return n.ini({
            rm: function (ad) {
                switch (ad.type) {
                    case"div_ready":
                        P = ad.sdiv;
                        E = ad.frm;
                        break;
                    case"give_data":
                        J = ad.data.q;
                        ac = ad.data.s;
                        var ae = ad.data.z || [];
                        W = [];
                        for (var af = 0; af < ae.length; af++) {
                            var ag = ae[af];
                            if (ag.type == 1 || ag.type == 2) {
                                W.push(ae[af])
                            }
                        }
                        rsv_sug = ad.data.t;
                        if (P) {
                            M()
                        }
                        break;
                    case"key_enter":
                        Y();
                        break;
                    case"key_up":
                        L();
                        break;
                    case"key_down":
                        Q();
                        break;
                    case"hide_div":
                        O();
                        break;
                    case"mousedown_other":
                        O();
                        break;
                    case"window_blur":
                        O();
                        break;
                    case"need_resize":
                        aa();
                        break
                }
            }
        })
    })();
    var z = (function () {
        var C = document.forms[0];

        function I() {
            if (l("bdsug_ipt_sug")) {
                if (l("bdsug_ipt_sug").value == y(l("kw1").value)) {
                    p({rsv_n: 1, sug: 1})
                } else {
                    p({f: 1})
                }
            }
        }

        u(C, "submit", I);
        function H() {
            I();
            h({inputT: a > 0 ? (new Date().getTime() - a) : 0});
            C.onsubmit();
            C.submit()
        }

        function E(J) {
            h(J);
            h({inputT: a > 0 ? (new Date().getTime() - a) : 0});
            p({sug: 1, rsv_n: 1});
            C.onsubmit();
            C.submit()
        }

        return n.ini({
            rm: function (J) {
                switch (J.type) {
                    case"clk_submit":
                        E({oq: J.oq, rsp: J.rsp, f: 3, rsv_sug: q, rsv_sug2: 1, rsv_sug5: J.rsv_sug5});
                        break;
                    case"ent_submit":
                        E({oq: J.oq, rsp: J.rsp, f: 3, rsv_sug: q, rsv_sug2: 0});
                        break;
                    case"submit":
                        H();
                        break
                }
            }
        })
    })();
    var c = (function () {
        var C = {};

        function I(J) {
            if (typeof C[J] == "undefined") {
                c.dm({type: "request_data", wd: J})
            } else {
                c.dm({type: "give_data", data: C[J]})
            }
        }

        function H(J) {
            C[J.q] = J;
            c.dm({type: "give_data", data: C[J.q]})
        }

        function E(M, L) {
            if (typeof C[M] != "undefined") {
                if (L.length > 0) {
                    var J = [];
                    for (var K = 0; K < L.length; K++) {
                        J.push(L[K].value)
                    }
                    C[M].s = J;
                    c.dm({type: "give_data", data: C[M]})
                }
            }
        }

        return n.ini({
            rm: function (J) {
                switch (J.type) {
                    case"response_data":
                        H(J.data);
                        break;
                    case"need_data":
                        I(J.wd);
                        break;
                    case"update_data":
                        E(J.word, J.data);
                        break
                }
            }
        })
    })();
    var v = (function () {
        var C;
        var E;

        function H(J) {
            var I = "http://suggestion.baidu.com/su";
            v.dm({type: "need_cookie"});
            if (C) {
                document.body.removeChild(C)
            }
            C = o("SCRIPT");
            C.src = I + "?wd=" + encodeURIComponent(J) + "&p=" + E + "&cb=window.bdsug.sug&from=superpage&t=" + (new Date()).getTime();
            C.charset = "gb2312";
            document.body.appendChild(C);
            h({rsv_sug3: ++k});
            x = new Date().getTime();
            d = false;
            b = setTimeout(function () {
                h({rsv_sug4: j += 5000});
                d = true
            }, 5000);
            if (!window._LogSearchBoxChanged) {
                F.use("ps/sug", function (K) {
                    K.searchLog()
                });
                window._LogSearchBoxChanged = true
            }
        }

        return n.ini({
            rm: function (J) {
                switch (J.type) {
                    case"request_data":
                        H(J.wd);
                        break;
                    case"give_cookie":
                        var I = J.sug;
                        if (I > 0) {
                            I = 3
                        }
                        E = I;
                        break
                }
            }
        })
    })();
    bdsug.sug = function (C) {
        bdsug.dm({type: "response_data", data: C});
        if (!d) {
            var E = l("kw1");
            if (E.value.toLowerCase() == C.q) {
                h({rsv_sug1: ++m})
            }
            clearTimeout(b);
            h({rsv_sug4: j += (new Date().getTime() - x)})
        }
    };
    bdsug.initSug = function () {
        bdsug.dm({type: "init"})
    };
    n.ini(bdsug);
    var f = (function () {
        function C() {
            if (navigator.cookieEnabled) {
                document.cookie = "su=0; domain=www.baidu.com"
            }
        }

        function E() {
            var H = (navigator.cookieEnabled && /sug=(\d)/.test(document.cookie) ? RegExp.$1 : 3);
            f.dm({type: "give_cookie", sug: H})
        }

        return n.ini({
            rm: function (H) {
                switch (H.type) {
                    case"close":
                        C();
                        break;
                    case"need_cookie":
                        E();
                        break
                }
            }
        })
    })();
    var e = (function () {
        var M = l("kw1");
        var H;
        var J = document.forms[0];
        var N;

        function L() {
            if (H.offsetWidth != 0 && M.offsetWidth != H.offsetWidth) {
                e.dm({type: "need_resize"})
            }
        }

        function I() {
            H = o("DIV");
            H.id = "sd_" + new Date().getTime();
            H.className = "s-ps-sug";
            H.style.display = "none";
            J.appendChild(H);
            if (r && r <= 6) {
                N = o("IFRAME");
                N.style.display = "none";
                N.style.position = "absolute";
                H.parentNode.insertBefore(N, H)
            }
        }

        function K(O) {
            O = O || window.event;
            var P = O.target || O.srcElement;
            if (P == M) {
                return
            }
            while (P = P.parentNode) {
                if (P == H) {
                    return
                }
            }
            e.dm({type: "mousedown_other"})
        }

        function C() {
            e.dm({type: "window_blur"})
        }

        function E() {
            var P = "#" + H.id;
            var O = [];
            e.dm({type: "div_ready", sdiv: H, frm: N});
            setInterval(L, 100);
            u(document, "mousedown", K);
            u(window, "blur", C);
            O.push(P + "{border:1px solid #817F82;position:absolute;top:32px;left:0}");
            O.push(P + " table{width:100%;background:#fff;cursor:default}");
            O.push(P + " td{color:#000;font:14px arial;height:25px;line-height:25px;padding:0 8px}");
            O.push(P + " td b{color:#000}");
            O.push(P + " .mo{background:#ebebeb}");
            O.push(P + " .ml{background:#fff}");
            O.push(P + " td.sug_storage{color:#7A77C8}");
            O.push(P + " td.sug_storage b{color:#7A77C8}");
            O.push(P + " .sug_del{font-size:12px;color:#666;text-decoration:underline;float:right;cursor:pointer;display:none}");
            O.push(P + " .sug_del{font-size:12px;color:#666;text-decoration:underline;float:right;cursor:pointer;display:none}");
            O.push(P + " .mo .sug_del{display:block}");
            O.push(P + " .sug_ala{border-bottom:1px solid #e6e6e6}");
            O.push(P + " td h3{line-height:14px;margin:6px 0 4px 0;font-size:12px;font-weight:normal;color:#7B7B7B;padding-left:20px;background:url(img/sug_bd.png) no-repeat left center}");
            O.push(P + " td p{font-size:14px;font-weight:bold;padding-left:20px}");
            O.push(P + " td p span{font-size:12px;font-weight:normal;color:#7B7B7B}");
            w(O.join(""))
        }

        bdsug.sug.initial = E;
        return n.ini({
            rm: function (O) {
                switch (O.type) {
                    case"start":
                        E();
                        break;
                    case"init":
                        I();
                        break
                }
            }
        })
    })();
    g.on("need_data", c);
    g.on("close_div", D);
    g.on("key_enter", D);
    g.on("key_up", D);
    g.on("key_down", D);
    g.on("hide_div", D);
    g.on("start", e);
    c.on("request_data", v);
    c.on("give_data", D);
    bdsug.on("response_data", c);
    bdsug.on("init", e);
    D.on("update_data", c);
    D.on("clk_submit", g, z);
    D.on("ent_submit", g, z);
    D.on("submit", z);
    D.on("key_select", g);
    D.on("close", g, f);
    D.on("mousedown_tr", g);
    e.on("mousedown_other", D);
    e.on("need_resize", D);
    e.on("div_ready", g, D);
    e.on("window_blur", D);
    v.on("need_cookie", f);
    f.on("give_cookie", v)
};
F.module("ps/sug", function (c, b, a) {
    b.init = function () {
        bds.se.sugsync();
        window.bdsug.initSug()
    };
    b.pssubmit = function () {
        var e = a.base;
        var d = s_session.userProp.searchAgroupGuide;
        if (!d) {
            var f = baidu.packPlayer;
            if (f && s_session.yuce && s_session.yuce != "1") {
                if (f.getState() == "play") {
                    d = true;
                    a.base.g("form1").target = "_blank"
                } else {
                    d = false;
                    a.base.g("form1").target = "_self"
                }
            }
        }
        if (d && e.g("kw1")) {
            setTimeout(function () {
                e.g("kw1").value = "";
                e.g("kw1").focus()
            }, 1);
            setTimeout(function () {
                a.use("page/info", function (h) {
                    var j = h.getInfo(), k = "focus";
                    if (j && j.isFocus) {
                        k = "blur"
                    }
                    a.fire("searchBtnClick", {opType: "click", openMode: "new" + k})
                })
            }, 100)
        } else {
            a.fire("searchBtnClick", {opType: "click", openMode: "current"})
        }
        var g = a.base.g("bd_fm_search_tip");
        if (g) {
            a.base.setStyle(g, "display", "none")
        }
    };
    b.searchLog = function () {
        a.fire("queryChange", {opType: "querychange"})
    }
});
F.module("page/info", function (c, b, a) {
    var d = a.base, e = {isFocus: true};
    d.on(window, "focus", function () {
        e.isFocus = true
    });
    d.on(window, "blur", function () {
        e.isFocus = false
    });
    b.getInfo = function () {
        return e
    }
});
F.module("page/analyse", function (d, c, a) {
    var e = a.base;
    c.runCssDetect = function () {
        e.addEventListener(window, "load", function () {
            setTimeout(function () {
                b(1);
                setTimeout(function () {
                    b(2, function () {
                        setTimeout(function () {
                            b(3)
                        }, 3000)
                    })
                }, 2000)
            }, 1000)
        })
    };
    var b = function (f, g) {
        if (baidu.dom.getStyle(e.g("s_main"), "display") == "none") {
            if (f == 1) {
                e.loadCss(e.g("s_superpage_css_lnk").href + "?v=9527")
            }
            a.fire("cssLoadFailed", {counter: f});
            g && g()
        }
    }
});
F.module("news/news", function (q, J, A) {
    var j = A.base, u = "hithot_" + s_session.portrait + "_word", a = "@+&+@", E, l = false, r = false, D = false, z = false, h = false, c, y = false, v = new (q("common/strpx").Strpx)("normal 12px arial,\5b8b\4f53,sans-serif"), d = q("common/user_attr"), H = j.q("s-mod-hotnews-subnav").pop(), t = j.g("s_mod_hotnews_img_viewer");

    function B(M, L) {
        r = M;
        var K = j.g("s_mod_topsearch");
        if (!K) {
            return
        }
        var N = j.getStyle("s_mod_topsearch", "display");
        if (M && N == "none") {
            j.setStyles(K, {display: "", height: ""});
            L && L();
            A.fire("addHotModFromAddLayer");
            A.fire("newUserShow", {opType: "newsShow", hotversion: s_session.userTips.newsHalfVersion})
        }
        if (!l && N == "block") {
            setTimeout(function () {
                A.fire("newUserShow", {opType: "newsShow", hotversion: s_session.userTips.newsHalfVersion})
            }, 3000);
            l = true
        }
        if (M && N == "block" || !M && N == "none") {
            return false
        }
        E = j.g("hot_allnews_data") ? j.jsonParse(j.trim(j.g("hot_allnews_data").innerHTML)) : false;
        if (!E || !E.rollNews || E.rollNews.legnth < 1 || !E.hotWords || E.hotWords.legnth < 1 || !E.picNews || E.picNews.legnth < 1) {
            return false
        }
        if (!z) {
            p(false);
            z = true
        }
        if (M) {
            setTimeout(function () {
                F.call("news/news_ext", "rollNews")
            }, 1000)
        }
        C(E.hotWords);
        m()
    }

    function p(L) {
        !L && j.on("s_mod_hotnews_img_viewer", "click", function (N) {
            var M = j.children(j.q("s-mod-hotnews-img-title")[0])[0];
            A.fire("newsClick", {
                url: j.getAttr(M, "href"),
                title: M.innerHTML,
                opType: "pic",
                tab: "hot",
                hotversion: s_session.userTips.newsHalfVersion
            })
        });
        j.on(t, "mouseover", function () {
            j.addClass(t, "s-hotnews-img-viewer-hover")
        });
        j.on(t, "mouseout", function () {
            j.removeClass(t, "s-hotnews-img-viewer-hover")
        });
        !L && j.on(j.q("s-mod-hotnews-img-title")[0], "click", function (N) {
            var M = j.children(j.q("s-mod-hotnews-img-title")[0])[0];
            A.fire("newsClick", {
                url: j.getAttr(M, "href"),
                title: M.innerHTML,
                opType: "pic",
                tab: "hot",
                hotversion: s_session.userTips.newsHalfVersion
            })
        });
        !L && j.on("s-mod-hotnews-img-prev", "click", function () {
            F.call("news/hotnews_ext", "setPre");
            A.fire("newsClick", {opType: "pre", tab: "hot", hotversion: s_session.userTips.newsHalfVersion})
        });
        !L && j.on("s-mod-hotnews-img-next", "click", function () {
            F.call("news/hotnews_ext", "setNxt");
            A.fire("newsClick", {opType: "next", tab: "hot", hotversion: s_session.userTips.newsHalfVersion})
        });
        var K = j.children(H);
        j.forEach(K, function (M) {
            j.on(M, "mouseover", function () {
                var O = this.innerHTML, N = E.picNews.length - O - 1;
                beShowNews = E.picNews[N];
                beShowNews.index = N;
                F.use("news/hotnews_ext", function (P) {
                    P.setPicnews(beShowNews);
                    P.setSubnav(N)
                })
            })
        });
        !L && j.on("s_mod_hot_roll_wrapper", "click", function (N) {
            var M = j.event.getTarget(N || window.event);
            if (M.tagName.toLowerCase() == "a") {
                A.fire("newsClick", {
                    title: M.innerHTML,
                    url: j.getAttr(M, "href"),
                    opType: "roll",
                    tab: "hot",
                    hotversion: s_session.userTips.newsHalfVersion
                })
            }
        });
        !L && j.on("s-hotnews-change-btn", "click", function () {
            x({rebind: true});
            y = true;
            A.fire("newsClick", {opType: "clickChange", hotversion: s_session.userTips.newsHalfVersion})
        });
        !L && j.on("s_mod_hotword_content", "click", function (N) {
            var M = N.srcElement ? N.srcElement : N.target;
            if (M.tagName.toUpperCase() == "EM") {
                A.fire("newsClick", {
                    opType: "click",
                    hotversion: s_session.userTips.newsHalfVersion,
                    word: j.getAttr(M, "data-title"),
                    position: j.getAttr(M.parentNode, "data-info")
                })
            }
        });
        j.on("s_mod_topsearch", "mouseover", function () {
            F.use("news/idio", function (M) {
            })
        });
        j.g("s_news_tab_hot") && j.on("s_news_tab_hot", "click", function () {
            j.setStyle("s_news_idio_settings", "display", "none");
            j.setStyle("s_news_hot_settings", "display", "block");
            F.use("news/hotnews_ext", function (M) {
                M.showHot();
                F.call("news/news_ext", "setRoll", true)
            })
        });
        j.g("s_news_tab_idio") && j.on("s_news_tab_idio", "click", function () {
            j.setStyle("s_news_hot_settings", "display", "none");
            F.use("news/hotnews_ext", function (M) {
                M.showIdio();
                F.call("news/news_ext", "setRoll", false)
            })
        })
    }

    function C(K) {
        c = K;
        n(c, x)
    }

    function m() {
        var K = j.g("s_mod_topsearch");
        if (!K || h) {
            return false
        }
        j.on(K, "mouseover", function (L) {
            if (h) {
                return false
            }
            F.use("news/hotnews_ext", function (M) {
                M.extInit()
            });
            h = true
        })
    }

    function x(K) {
        data = K.data || c;
        var L = w(data);
        k(L, K.rebind);
        D = true
    }

    function k(M, O) {
        M = M || [];
        if (M.length < 1) {
            j.g("s_mod_hotword_content").innerHTML = '<div id="s_hot_waiting_tips">系统错误，资源加载失败。</div>';
            return false
        }
        var P = '<ul class="clearfix" id="s_topsearch">';
        for (var K = 0; K < 12 && K < M.length; K++) {
            var L = M[K];
            if (L) {
                var N = j.string.encodeHTML(j.string.trim(j.string.decodeHTML(L.key)));
                if (L._viewed) {
                    P += '<li class="s-topsearch-item viewed"'
                } else {
                    P += '<li class="s-topsearch-item"'
                }
                if (j.isIE) {
                    P += " hidefocus"
                }
                if (K % 2 == 1) {
                    P += ' style="padding-left:8px;width: 155px;"><div data-info="' + K + '">'
                } else {
                    P += ' style="width: 155px;"><div data-info="' + K + '">'
                }
                P += '<span class="s-topsearch-item-dot"></span><a data-info="' + K + '" ' + (L.ispm == 1 ? 'ismanual="true"' : "") + ' target="_blank" ' + (L.isred == 1 ? 'class="by-red"' : (L.ispm == 1 ? 'class="by-pm"' : "")) + ' href="' + L.detailurl + '&rsv_spt=2&issp=2" ' + ((L.cut == 1) ? 'data-cut="1"' : "") + ' title="' + N + '"><em class="word-key" data-title="' + N + '" data-new="' + L.isnew + '">' + g(N, 108) + "</em>" + (L.isnew == "true" ? '<em class="nlabel">新!</em>' : "") + "</a></div></li>"
            }
        }
        P += "</ul>";
        j.g("s_mod_hotword_content").innerHTML = P;
        j.each(j.q("word-key"), function (Q) {
            j.on(Q, "mousedown", function () {
                window.urSendClick = window.urSendClick || function () {
                    };
                window.urSendClick({pid: "super", mod: "hot"})
            })
        });
        if (O) {
            F.use("news/hotnews_sug", function (Q) {
                var R = new Q.HithotSuggest();
                F.use("news/hotnews_sug_job", function (S) {
                    S.initHitHotSuggest()
                })
            })
        }
    }

    function w(P) {
        var M = 0;
        var O = 12;
        var L = [];
        if (!D) {
            o(P)
        }
        if (O >= P.length) {
            return P
        }
        for (var N in P) {
            if (P[N]._islast && P[N]._islast == true) {
                P[N]._islast = false;
                M = parseInt(N) + 1;
                if (M >= P.length) {
                    M = 0
                }
                break
            }
        }
        var K = 0;
        while (K < O && M < P.length) {
            K++;
            L.push(P[M]);
            M++;
            if (M == P.length) {
                M = 0
            }
        }
        M -= 1;
        if (M < 0) {
            M = P.length - 1
        }
        P[M]._islast = true;
        return L
    }

    function o(N) {
        if (!N || N.length < 1) {
            return false
        }
        var K = [];
        var L = [];
        for (var M in N) {
            if (N[M]._viewed) {
                N[M].isnew = false;
                L.push(N[M])
            } else {
                K.push(N[M])
            }
        }
        if (L.length > 0) {
            for (var M in L) {
                K.push(L[M])
            }
        }
        var M = 0;
        while (M < N.length) {
            N[M] = K[M];
            M++
        }
        return N
    }

    function n(L, K) {
        F.use("common/localstorage", function (M) {
            if (!M || !M.ls) {
                return
            }
            var N = M.ls;
            N.get(u, function (P, U) {
                var Q = "";
                if (P == 0 && U) {
                    Q = U.split(a)
                }
                if (Q) {
                    for (var O in Q) {
                        var T = Q[O];
                        for (var S in L) {
                            var R = L[S].key;
                            if (R == T) {
                                L[S]._viewed = true;
                                break
                            }
                        }
                    }
                }
                K && K({data: L, rebind: (r ? true : false)})
            })
        })
    }

    function g(L, K, M) {
        return j.string.encodeHTML(v.substringByPx(j.string.decodeHTML(L), K, M || "..."))
    }

    var b = function () {
        return y
    };
    var f = function (K) {
        y = K
    };

    function s() {
        return c
    }

    function e(K) {
        A.listen("news/hotnews_ext", "deleteHot", K)
    }

    function I() {
        A.fire("deleteHotMod")
    }

    J.init = B;
    J.strWord = g;
    J.getWordShowSource = b;
    J.getData = s;
    J.proceDelHot = e;
    J.onDeleteEnd = I
});