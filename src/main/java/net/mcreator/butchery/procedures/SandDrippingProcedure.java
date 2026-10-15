package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class SandDrippingProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
            int n;
            Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty) {
                Property<?> _getip3 = (IntegerProperty)property;
                n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
            } else {
                n = -1;
            }
            if (n == 1) {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        }
        ButcheryMod.queueServerWork(28, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip14 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip14);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(56, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip26 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip26);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(84, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip38 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip38);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(112, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip50 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip50);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(140, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip62 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip62);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(168, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip74 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip74);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(196, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip86 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip86);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(224, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip98 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip98);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(252, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip110 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip110);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(280, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip122 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip122);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(308, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip134 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip134);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(336, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip146 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip146);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(364, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip158 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip158);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(392, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip170 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip170);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(420, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip182 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip182);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(448, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip194 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip194);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(476, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip206 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip206);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(504, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip218 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip218);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(532, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip230 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip230);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(560, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip242 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip242);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(588, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip254 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip254);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(616, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip266 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip266);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(644, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip278 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip278);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(672, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip290 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip290);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(700, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip302 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip302);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(728, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip314 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip314);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(756, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip326 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip326);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(784, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip338 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip338);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(812, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip350 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip350);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(840, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    Property<?> _getip362 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip362);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
        ButcheryMod.queueServerWork(868, () -> {
            if (world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) {
                int n;
                Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                if (patt0$temp instanceof IntegerProperty) {
                    IntegerProperty _getip374 = (IntegerProperty)patt0$temp;
                    n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip374);
                } else {
                    n = -1;
                }
                if (n == 1) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                    ButcheryMod.queueServerWork(5, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(10, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                    ButcheryMod.queueServerWork(15, () -> {
                        if (world instanceof ServerLevel) {
                            ServerLevel _level = (ServerLevel)world;
                            _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.SANDPARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                        }
                    });
                }
            }
        });
    }
}

